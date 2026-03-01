pipeline {
    agent {
        label 'INT-CyberSure'
    }

    stages {
        stage('Clean Workspace') {
            steps {
                cleanWs()
            }
        }

        stage('Code Clone') {
            steps {
                git branch: 'UAT', credentialsId: 'prasit1', url: 'https://prasit1@bitbucket.org/Indus_Net/cybersure-clientportal-web.git'
            }
        }

        stage('Copy Secrets') {
            steps {
                sh '''
                echo "Copying secrets folder from home"
                # Make sure secrets folder exists
                if [ -d /home/ubuntu/db_secrets ]; then
                    cp -r /home/ubuntu/db_secrets ./
                    echo "Secrets copied successfully."
                else
                    echo "Warning: /home/ubuntu/db_secrets does not exist!"
                fi
                mkdir -p ./secrets
                cp db_secrets/db_user.txt ./secrets/db_user.txt
                cp db_secrets/db_password.txt ./secrets/db_password.txt'''
            }
        }

        stage('Docker Compose Up') {
            steps {
                sh '''
                echo "Starting docker-compose for cybersure-clientportal-web..."
                sudo chmod +x docker-compose.yml || true
                sudo docker compose down || true
                sudo docker compose up --build -d
                '''
            }
        }
    }

    post {
        always {
            echo "✅ cybersure-clientportal-web deployment pipeline finished."
        }
        failure {
            echo "❌ Pipeline failed — please check the logs above."
        }
    }
}
