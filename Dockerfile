FROM ubuntu:22.04
LABEL maintainer help.techeduhub@gmail.com
RUN apt-get update -y
RUN apt-get install openjdk-17-jdk wget -y
ADD /target/mywebapp.war mywebapp.war
EXPOSE 5050
ENTRYPOINT ["java","-jar","mywebapp.war"]