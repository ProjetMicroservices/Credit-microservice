FROM java:8
EXPOSE 8090
ADD /target/Credit_Microservice-0.0.1-SNAPSHOT.jar Credit_Microservice-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar" , "Credit_Microservice-0.0.1-SNAPSHOT.jar" ]