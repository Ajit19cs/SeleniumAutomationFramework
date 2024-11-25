pipeline {
    agent any

    stages {
        stage('Build project') {
            steps {
                bat "mvn clean package -DskipTests"
            }
        }
        
        stage('Build image ') {
            steps {
                bat "docker build -t ajitdocker/selenium ."
            }
        }
        
        stage('Build push ') {
            steps {
                bat "docker push ajitdocker/selenium"
            }
        }
        
        
        
    }
}
