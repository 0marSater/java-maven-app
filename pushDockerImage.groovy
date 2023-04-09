def pushImage(){
    // you can replace you repo name here, in my vase i use dockerhub private repo
    def repo_name = "omarsater/private-repo"
    echo "Pushing ${FULL_IMAGE_NAME}"
    sh "docker tag $FULL_IMAGE_NAME $repo_name:$FULL_IMAGE_NAME"
    sh "docker push $repo_name:$FULL_IMAGE_NAME"
}
return this
