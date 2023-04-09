def loginToEc2(){

    def cmd  = "docker-compose -f docker-compose.yaml up"
    sshagent(['ec2 connection']) {
        sh "ssh -o StrictHostKeyChecking=no ec2-user@13.37.207.20 ${cmd} "

    }
}
return this