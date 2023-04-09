def loginToEc2(){
    sshagent(['ec2 connection']) {

        //replace your ec2 public ip here
        def ec2PublicIP = "xxxx"

        // you can copy docker-compose.yaml file to the server and run it in case of having multiple service
        //sh "scp docker-compose.yaml ec2-user@$ec2PublicIP:/home/ec2-user"

        sh "ssh -o StrictHostKeyChecking=no ec2-user@$ec2PublicIP"

    }
}
return this