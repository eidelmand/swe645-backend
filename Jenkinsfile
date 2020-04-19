pipeline {
   agent any	
        tools {
          // Install the Maven version configured as "M3" and add it to the path.
          maven "Maven 3.6.3"
          }
    environment {
        PROJECT_ID = 'extreme-citadel-271521'//'654482500446'
        CLUSTER_NAME = 'swe645'
        LOCATION = 'us-east1-c'
        CREDENTIALS_ID = 'gke'
    }
    stages {
        /*stage("Checkout code") {
            steps {
            }
        }*/
        stage("Build image") {
            steps {
                script {

                    checkout scm
                   // sh 'ls'
                   // sh 'mvn -B clean package'
                    sh 'ls target/'
                   // sh 'mv target/test1-0.0.1-SNAPSHOT.war swe645.war'
                    myapp = docker.build("eyaron94/swe645_2:${env.BUILD_ID}")
                }
            }
        }
        stage("Push image") {
            steps {
                script {
                    docker.withRegistry('https://registry.hub.docker.com', 'dockerhub') {
                            myapp.push("latest")
                            //myapp.push("${env.BUILD_ID}")
                    }
                }
            }
        }
        stage('Deploy to GKE') {
            steps{
		   sh 'gcloud config set project extreme-citadel-271521'	
		    sh 'gcloud container clusters get-credentials swe645 --zone us-east1-c'		
		    sh 'kubectl set image deployments/swe645-backend swe645-backend=registry.hub.docker.com/eyaron94/swe645_backend'
		}
        }
    }
}
