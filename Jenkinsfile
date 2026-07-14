pipeline{
  agent any

  stages{
      stage("Checkout"){
         steps {
            checkout scm
               }
              }

         stage("Build"){
                  steps {
                     sh 'chmod +x gradlew'
                     sh './gradlew clean build'
                        }
                       }
        stage("DOCKER Build"){
            steps {
                sh 'docker build -t springboot-devsecops:v1 .'
            }
        }


                      }
         }