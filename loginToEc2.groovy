def loginToEc2(){
    sshagent(['ec2 connection']) {
        def ec2PublicIP = "xxxx"
        sh "ssh -o StrictHostKeyChecking=no ec2-user@$ec2PublicIP"
    }
}
return this