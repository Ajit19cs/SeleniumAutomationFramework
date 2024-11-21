#!/bin/bash

#-------------------------------------------------------------------
#  This script expects the following environment variables:
#     HUB_HOST
#     BROWSER
#     THREAD_COUNT
#     TEST_SUITE
#     ELASTICSEARCH_HOST
#-------------------------------------------------------------------

# Let's print what we have received
echo "-------------------------------------------"
echo "HUB_HOST      : ${HUB_HOST:-hub}"  # Defaults to 'hub' if HUB_HOST is not provided
echo "BROWSER       : ${BROWSER:-chrome}"  # Defaults to 'chrome' if BROWSER is not provided
echo "THREAD_COUNT  : ${THREAD_COUNT:-1}"  # Defaults to 1 if THREAD_COUNT is not provided
echo "TEST_SUITE    : ${TEST_SUITE}"  # Assumes TEST_SUITE is provided as input
echo "ELASTICSEARCH_HOST : ${ELASTICSEARCH_HOST:-elasticsearch}"  # Defaults to 'elasticsearch' if ELASTICSEARCH_HOST is not provided
echo "-------------------------------------------"

# Do not start the tests immediately. Hub and Elasticsearch must be ready
echo "Checking if Selenium Hub is ready..!"
count=0
while [ "$(curl -s http://${HUB_HOST:-hub}:4444/status | jq -r .value.ready)" != "true" ]
do
  count=$((count+1))
  echo "Attempt: ${count} for Selenium Hub"
  if [ "$count" -ge 30 ]
  then
      echo "**** HUB IS NOT READY WITHIN 30 SECONDS ****"
      exit 1
  fi
  sleep 1
done

# Now check if Elasticsearch is ready with a green status
echo "Checking if Elasticsearch is ready..!"
count=0
while [ "$(curl -s http://${ELASTICSEARCH_HOST:-elasticsearch}:9200/_cluster/health?pretty | jq -r .status)" != "green" ]
do
  count=$((count+1))
  echo "Attempt: ${count} for Elasticsearch health"
  if [ "$count" -ge 60 ]
  then
      echo "**** ELASTICSEARCH IS NOT READY WITHIN 30 SECONDS ****"
      exit 1
  fi
  sleep 1
done

# At this point, both Selenium Grid and Elasticsearch should be up and running!
echo "Selenium Grid and Elasticsearch are both ready. Running the test...."

# Start the Java command to run tests
java -cp 'libs/*' \
     -Dselenium_grid_enabled=true \
     -Dselenium_grid_hubhost="${HUB_HOST:-hub}" \
     -Delasticsearch_host="${ELASTICSEARCH_HOST:-elasticsearch}" \
     -Dbrowser="${BROWSER:-chrome}" \
     org.testng.TestNG \
     -threadcount "${THREAD_COUNT:-1}" \
     suites/"${TEST_SUITE}"
