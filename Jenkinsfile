pipeline {
    agent any

    environment {
        DOCKER_CREDENTIALS = 'dockerhub-creds' // Your Jenkins credentials ID for Docker Hub
        DOCKER_IMAGE = 'ajit19cs/selenium'
    }

    stages {
        stage('Build Jar') {
            steps {
                script {
                    docker.image('maven:3.9.3-eclipse-temurin-17-focal').inside {
                        sh 'mvn clean package -DskipTests'
                    }
                }
            }
        }

        stage('Build Image') {
            steps {
                script {
                    app = docker.build('ajit19cs/selenium')
                }
            }
        }

        stage('Push Image') {
            steps {
                script {
                    docker.withRegistry('', 'dockerhub-creds') {
                        app.push("latest")
                    }
                }
            }
        }
    }
}
