pipeline {
    agent any

    environment {
        DOCKER_CREDENTIALS = 'dockerhub-creds' // Your Jenkins credentials ID for Docker Hub
        DOCKER_IMAGE = 'ajit19cs/selenium'
    }

    stages {
        stage('Build project') {
            steps {
                bat "mvn clean package -DskipTests"
            }
        }

        stage('Validate and Set Docker Context') {
            steps {
                script {
                    // Check the current Docker context
                    def currentContext = bat(returnStdout: true, script: 'docker context show').trim()

                    // Set the context to 'default' if it's not already set
                    if (currentContext != 'default') {
                        echo "Docker context is set to '${currentContext}', switching to 'default'."
                        bat 'docker context use default'
                    } else {
                        echo "Docker context is already set to 'default'."
                    }
                }
            }
        }

        stage('Build image') {
            steps {
                bat "docker build -t ${DOCKER_IMAGE}:latest ."
            }
        }

        stage('Push image') {
            steps {
                script {
                    docker.withRegistry('https://index.docker.io/v1/', DOCKER_CREDENTIALS) {
                        // Push the image with 'latest' tag
                        bat "docker push ${DOCKER_IMAGE}:latest"

                        // Tag the 'latest' image with the build number
                        bat "docker tag ${DOCKER_IMAGE}:latest ${DOCKER_IMAGE}:${env.BUILD_NUMBER}"

                        // Push the build number tagged image
                        bat "docker push ${DOCKER_IMAGE}:${env.BUILD_NUMBER}"
                    }
                }
            }
        }
    }
}
