
def buildJar(){
    
    echo "building the application"
    sh 'mvn package'
}

def buildDockerImage() {

    echo "Start building the docker image: ${FULL_IMAGE_NAME}"

    sh "cd ${WORKSPACE} && docker build -t ${FULL_IMAGE_NAME} ."
}

def dockerLogin(){

    // first, choose a repo to login with, in this case i use dockerhub

    // second, add ur credentials in ur jenkins credentials

    echo "login to docker hub..."

    withCredentials([usernamePassword(credentialsId: 'dockerHub', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'echo $PASS | docker login -u $USER --password-stdin'
    }
}

def pushImage(){

    echo "Start pushing image .."

    // you can replace you repo name here, in my vase i use dockerhub private repo
    def repo_name = "omarsater/private-repo"

    echo "Pushing ${FULL_IMAGE_NAME}"

    sh "docker tag $FULL_IMAGE_NAME $repo_name:$FULL_IMAGE_NAME"

    sh "docker push $repo_name:$FULL_IMAGE_NAME"
}
return this