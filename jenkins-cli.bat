# NB: You must run "gradlew jenkins-install" before this script will start jenkins
#     and "gradlew jenkins-configure" before you can use this script to configure jenkins

if "$1" = "start"
    java -jar ./jenkins/jenkins.war
else
    java -jar ./jenkins/jenkins-cli.jar -s http://localhost:8080 %$
fi