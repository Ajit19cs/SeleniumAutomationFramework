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
                bat "docker build -t ajit19cs/selenium ."
            }
        }
        
        stage('Build push ') {
            steps {
                bat "docker push ajit19cs/selenium"
            }
        }
        
        
        
    }
}
