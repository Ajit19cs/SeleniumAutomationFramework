pipeline {
    agent any

    stages {
        stage('Build project') {
            steps {
                sh "mvn clean package -DskipTests"
            }
        }
        
        stage('Build image ') {
            steps {
                sh "docker build -t ajitdocker/selenium ."
            }
        }
        
        stage('Build push ') {
            steps {
                sh "docker push ajitdocker/selenium"
            }
        }
        
        
        
    }
}
