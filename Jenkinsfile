pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                bat 'nmake'
                archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
            }
        }
    }
}