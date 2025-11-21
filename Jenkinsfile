pipeline {
    agent any
    tools {
        nodejs 'Node20'
    }
    stages {
        stage('Install') {
            steps {
                bat 'npm ci'
            }
        }
        stage('Run Cypress Tests') {
            steps {
                bat 'npm run test'  // This now generates results.xml
            }
        }
    }
    post {
        always {
            // Shows test results (pass/fail count) in Jenkins
            junit 'cypress/results/results.xml'

            // Save videos and screenshots
            archiveArtifacts artifacts: 'cypress/videos/**/*.mp4', allowEmptyArchive: true
            archiveArtifacts artifacts: 'cypress/screenshots/**/*.png', allowEmptyArchive: true
        }
    }
}