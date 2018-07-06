FROM ubuntu:bionic

#install Ubuntu essential tools
RUN apt update && apt upgrade -y

RUN apt install -y curl software-properties-common

# Install Java.
RUN \  
    echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | debconf-set-selections && \
    add-apt-repository -y ppa:webupd8team/java && \
    apt update && \
    apt install -y oracle-java8-installer && \
    rm -rf /var/lib/apt/lists/* && \
    rm -rf /var/cache/oracle-jdk8-installer

# Define commonly used JAVA_HOME variable
ENV JAVA_HOME /usr/lib/jvm/java-8-oracle

#Show java version
RUN java -version

WORKDIR /apps

ADD /person/target/person.jar /apps

RUN apt update

RUN apt install -y nginx

RUN mv /etc/nginx/sites-available/default /etc/nginx/sites-available/default.old

ADD weather/dist/ /apps

COPY default /etc/nginx/sites-available/

RUN service nginx restart

ENTRYPOINT [ "java","-jar","person.jar" ]

# Make port 8080 available to the world outside this container
EXPOSE 8080

EXPOSE 80

# # Define default command.
CMD ["bash"]
