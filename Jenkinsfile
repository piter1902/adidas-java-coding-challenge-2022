pipeline {
    agent {
        docker {
            image 'maven:3.9.0-eclipse-temurin-11' 
            args '-v /root/.m2:/root/.m2' 
        }
    }
    environment {
        CREDENTIAL_KEY = "CredentialKey"
    }
    stages {
        stage('Test') { 
            steps {
                sh 'mvn test'
            }
        }
        stage('Build Images') {
            steps {
                sh 'mvn clean install'
                sh "docker build -f adiclub-service/Dockerfile -t adidas-be-challenge-adiclubservice:v${env.BUILD_NUMBER} adiclub-service"
                sh "docker build -f email-service/Dockerfile -t adidas-be-challenge-emailservice:v${env.BUILD_NUMBER} email-service"
                sh "docker build -f priority-sale-service/Dockerfile -t adidas-be-challenge-prioritysaleservice:v${env.BUILD_NUMBER} priority-sale-service"
                sh "docker build -f public-service/Dockerfile -t adidas-be-challenge-publicservice:v${env.BUILD_NUMBER} public-service"
            }
        }
        stage('Deploy to K8s') {
            steps {
                withCredentials([sshUserPrivateKey(credentialsId: "${env.CREDENTIAL_KEY}", keyFileVariable: 'sshKey', usernameVariable: 'user')]) {
                    // Use credentials to deploy created images to Docker Registry and redeploy K8s
                }
            }
        }
    }
}