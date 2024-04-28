pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                bat 'clean build --stacktrace'
                archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
            }
        }
    }
}