pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                bat 'gradlew clean build'
                archiveArtifacts artifacts: '/app/build/outputs/apk/*.apk', fingerprint: true
            }
        }
    }
}