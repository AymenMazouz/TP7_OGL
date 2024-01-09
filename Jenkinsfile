pipeline {
      agent any
      stages {
 stage ('test') {
                steps {
                    bat 'gradlew.bat test'
                    archiveArtifacts 'build/test-results/'
                    cucumber reportTitle: 'Cucumber report',
                    fileIncludePattern: 'target/report.json',
                    trendsLimit: 10,
                    classifications: [
                        [
                           'key': 'Browser',
                            'value': 'Firefox'
                        ]
                    ]
                    junit 'build/test-results/test/TEST-Matrix.xml'
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
