pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                bat './gradlew clean assembleDebug'
                archiveArtifacts artifacts: '**/*.apk', fingerprint: true, onlyIfSuccessful: true
            }
        }
    }
}