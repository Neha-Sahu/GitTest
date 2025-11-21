pipeline {
    agent any
    tools {
        nodejs 'Node20'   // ← must match the name you gave in Global Tool Configuration
    }
    stages {
        stage('Install Dependencies') {
            steps {
                bat 'npm ci'   // clean install – fastest & reliable
            }
        }
        stage('Run Cypress Tests') {
            steps {
                bat 'npx cypress run --headless --browser chrome'
                // or just: bat 'npx cypress run'  (it will auto-pick chrome/edge)
            }
        }
    }
    post {
        always {
            // Save videos & screenshots even if tests fail
            archiveArtifacts artifacts: 'cypress/videos/**/*.mp4', allowEmptyArchive: true
            archiveArtifacts artifacts: 'cypress/screenshots/**/*.png', allowEmptyArchive: true
        }
    }
}
