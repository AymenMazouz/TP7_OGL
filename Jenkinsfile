pipeline {
    agent any
    stages {
        stage('test') {
            steps {
                bat './gradlew test'
            }
        }
    }
    post {
        success {
            script {
                def notifyToken = 'bbothk34jxh5juwrihmvlevopelrzlnf'
                sh "curl -X POST -H 'Content-Type: application/json' -d '{\"text\":\"Build réussi\"}' https://api.notify.events/v1/jenkins/${notifyToken}"
            }
        }
    }
}
