
def dockerLogin(){
    echo "login to docker hub..."
    withCredentials([usernamePassword(credentialsId: 'dockerHub', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh "echo $PASS | docker login -u $USER --password-stdin"
    }
}
return this