FROM openjdk:24
EXPOSE 8080
ADD target/k8s-sb-app.jar k8s-sb-app.jar
ENTRYPOINT ["java","-jar","/k8s-sb-app.jar"]