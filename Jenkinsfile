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
