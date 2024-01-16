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
                   bat './gradlew sonar'
                }
            }
        }
        stage("Code Quality") {
            steps {
                timeout(time: 1, unit: 'HOURS') {
                    // Parameter indicates whether to set pipeline to UNSTABLE if Quality Gate fails
                    // true ie set pipeline to UNSTABLE, false = don't
                    waitForQualityGate abortPipeline: true
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
