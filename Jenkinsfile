  environment{
    FULL_IMAGE_NAME = null
  }
pipeline {
  agent any
  tools{
    maven 'Maven'
  }
    stages {
        stage("User input") {
            steps{
                script{
                    FULL_IMAGE_NAME = input message: "Please, enter the full image name (with tag) you want to build: ",
                           parameters:[string(name: 'name', defaultValue: '', description: '')]
                    echo "The image name: ${FULL_IMAGE_NAME}."
                }
            }
        }
        stage("Build app"){
            steps{
                script{
                    def file = load "build.groovy"
                    file.buildJar()
                }
            }
        }
        stage("Build image") {
            steps{
                script{
                    def file= load "build.groovy"
                    file.buildDockerImage()
                    file.dockerLogin()
                    file.pushImage()

                }
            }
        }

        stage("Deploy"){
            steps{
                script{
                    def file = load "deploy.groovy"
                    file.loginToEc2()
                }
            }
        }
    }
}
