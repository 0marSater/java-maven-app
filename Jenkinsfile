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
            steps {
                script{
                    FULL_IMAGE_NAME = input message: "Please, enter the full image name (with tag) you want to build: ",
                           parameters:[string(name: 'name', defaultValue: '', description: '')]
                    echo "The image name: ${FULL_IMAGE_NAME}."
                }
            }
        }
        stage("Build app"){
            stage{
                steps{
                    def file = load "build.groovy"
                    file.buildJar()
                }
            }
        }
        stage("Build image") {
            steps {
                script {
                    def file= load "build.groovy"
                    file.buildDockerImage()
                }
            }
        }
        stage("Login to dockerhub"){
            steps{
                script{
                    def file= load "dockerhubLogin.groovy"
                    file.dockerLogin()
                }
            }
        }

        stage("Push docker image"){
            steps{
                script{
                    def file = load "pushDockerImage.groovy"
                    file.pushImage()
                }
            }
        }
        stage("Connecting to EC2"){
            steps{
                script{
                    def file = load "loginToEc2.groovy"
                    file.loginToEc2()
                }
            }
        }
    }
}