# java-maven-app
It's a small pipeline that simulate part of production environment.
The pipeline containes 4 stages:
1) User-input: to enter the name of image you want, or u can negelect this stage by hard coded the image and autmoate versioning it.
2) Build app: to build jar file.
3) Build image: to build docker image, login to docker hub and push image to it. 
4) Deploy: to deploy on AWS EC2 instance.
======
Some stages contain an exeternal groovy script to automate specific. 
Ex:  1 - build.groovy: to handle both build jar file and docker image stages.
     2 - deploy.groovy: to handle deployment steps on EC2 instance 
=====
we can abstract regular steps on more advance manner using jenkins-shared library.
     
finally, it is a small pipeline just to apply what i've learned about jenkins pipeline.
 
