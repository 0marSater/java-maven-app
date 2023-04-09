def pushImage(){
    echo "Pushing ${FULL_IMAGE_NAME}"
    sh "docker tag $FULL_IMAGE_NAME omarsater/private-repo:$FULL_IMAGE_NAME"
    sh "docker push omarsater/private-repo:$FULL_IMAGE_NAME"
}
return this
