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

        stage("SonarQube Analysis"){
            environment {
                SCANNER_HOME = tool 'SonarScanner'
            }
            steps {
               withSonarQubeEnv('SonarQube'){
                    sh '''
                         ${SCANNER_HOME}/bin/sonar-scanner \
                         -Dsonar.projectKey=springboot-devsecops \
                         -Dsonar.sources=. \
                         -Dsonar.java.binaries=build/classes
                       '''


                }

            }
        }
        stage("DOCKER Build"){
            steps {
                sh 'docker build -t springboot-devsecops:v1 .'
            }
        }

        stage("Run Container"){
            steps {
                sh '''
                docker   rm -f springboot-app || true
                docker   run -d --name  springboot-app -p 8080:8080  springboot-devsecops:v1
                '''
            }
        }

        stage('Health Check'){
            steps {
                sleep 20
                sh 'curl --fail http://host.docker.internal:8080/actuator/health'
                sh 'curl http://host.docker.internal:8080/employee/employee-details'
            }
        }


                      }
         }