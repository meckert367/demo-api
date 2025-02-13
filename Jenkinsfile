pipeline {
    agent any

    environment {
        SONAR_URL = 'http://sonarqube:9000'
        SONAR_TOKEN = credentials('sonar-token')
    }

    stages {
        stage('Build') {
            steps {
                sh './mvnw clean package -Dmaven.test.skip=true'
            }
        }
        stage('Test') {
            steps {
                sh './mvnw clean package jacoco:report'
            }
        }
        stage('Analysis') {
            steps {
                sh './mvnw sonar:sonar -Dsonar.host.url=${SONAR_URL} -Dsonar.token=${SONAR_TOKEN}'
            }
        }
    }
    post {
        success {
            echo 'Build and deployment successful'
        }
        failure {
            echo 'Build and deployment failed'
        }
        unstable {
            echo 'Build and deployment unstable'
        }
    }
}
