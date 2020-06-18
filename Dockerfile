# Use the latest image from UBUNTU installed in the machine
FROM ubuntu:latest

# Update ubuntu system
RUN apt-get update

RUN apt autoremove

# Install maven on ubuntu-selenium image
FROM maven:3.5-jdk-8-alpine

# Install git on ubuntu-selenium image
#RUN apt-get install -y git

# Get the repository onto the local system
#RUN git clone https://github.com/kanchan2899/RyanairAutomationSuite.git
RUN mkdir /ryanair
COPY . /ryanair
RUN echo "$PWD"


# Run the maven command to execute all the tests
WORKDIR "/ryanair"

RUN mvn -version


#FROM maven:3.5.3-jdk-8-alpine
#RUN mkdir /ryanair
#COPY . /ryanair
#RUN echo "$PWD"
#WORKDIR /ryanair
#
#RUN mvn clean install