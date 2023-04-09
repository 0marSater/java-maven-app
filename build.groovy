
def buildJar(){
    echo "building the application for branch $BRANCH_NAME"
    sh 'mvn package'
}

def buildDockerImage() {
    echo "building the docker image: ${FULL_IMAGE_NAME}"
    sh "cd ${WORKSPACE} && docker build -t ${FULL_IMAGE_NAME} ."
}
return this