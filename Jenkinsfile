pipeline {
      agent any
      stages {
        stage ('test') {
            steps {
                bat './gradlew test'
            }
        }
        stage('Code analysis') {
            steps {
                withSonarQubeEnv("sonar") {
                    bat './gradlew sonarqube'
                }
            }
        }



        stage("notification") {
            steps {
                    notifyEvents message: 'Pipeline <b> is sucessufuly termined</b>', token: 'bbothk34jxh5juwrihmvlevopelrzlnf'
                    mail bcc: '', body: 'Pipeline <b> is sucessufuly termined</b>', cc: '', from: '', replyTo: '', subject: 'process Success', to: 'ka_mazouz@esi.dz'
          }
        }
      }

      post {
         failure {
                   mail bcc: '', body: 'process Failed!!!', cc: '', from: '', replyTo: '', subject: 'process Faild', to: 'ka_mazouz@esi.dz'
         }
      }

}
