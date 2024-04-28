pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                bat 'gradlew clean build'
                archiveArtifacts artifacts: '**/build/libs/*.jar', fingerprint: true
            }
        }
    }
}