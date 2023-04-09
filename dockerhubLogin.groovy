
def dockerLogin(){
    // first, choose a repo to login with, in this case i use dockerhub
    // second, add ur credentials in ur jenkins credentials
    echo "login to docker hub..."
    withCredentials([usernamePassword(credentialsId: 'dockerHub', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'echo $PASS | docker login -u $USER --password-stdin'
    }
}
return this