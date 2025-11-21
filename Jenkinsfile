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
            // THIS LINE ADDS THE TEST RESULT TAB
            junit testResults: 'cypress/results/*.xml', allowEmptyResults: true

            // Keeps your videos and screenshots
            archiveArtifacts artifacts: 'cypress/videos/**/*.mp4', allowEmptyArchive: true
            archiveArtifacts artifacts: 'cypress/screenshots/**/*.png', allowEmptyArchive: true
        }
    }
        }
    }
}