pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                bat 'mvn clean build'
                archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
            }
        }
    }
}