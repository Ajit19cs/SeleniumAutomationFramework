pipeline {
    agent any

    environment {
        DOCKER_CREDENTIALS = 'dockerhub-creds' // Your Jenkins credentials ID for Docker Hub
        DOCKER_IMAGE = 'ajit19cs/selenium'
    }

    stages {
         stage('Build project') {
            steps {
                script {
                    // Use a Maven Docker container to build the project
                    docker.image('maven:3.9.3-eclipse-temurin-17-focal').inside {
                        sh 'mvn clean package -DskipTests'
                    }
                }
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
                bat "docker build -t ${DOCKER_IMAGE} ."
            }
        }
        
        stage('Push image') {
            steps {
                script {
                    docker.withRegistry('https://index.docker.io/v1/', DOCKER_CREDENTIALS) {
                        bat "docker push ${DOCKER_IMAGE}"
                    }
                }
            }
        }
    }
}
