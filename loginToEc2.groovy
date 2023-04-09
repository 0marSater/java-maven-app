def loginToEc2(){
    sshagent(['ec2 connection']) {
        sh "ssh -o StrictHostKeyChecking=no ec2-user@13.37.207.20"

    }
}
return this