FROM ibm-semeru-runtimes:open-17-jre-focal
EXPOSE 8080
ADD .target/*.jar ./app.jar
CMD java -Djava.security.egd=file:/dev/./urandom -jar app.jar

