FROM library/openjdk:11-slim
EXPOSE $PORT
COPY target/java-user-api-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT exec java -Xms724m -Xmx724m -jar $JAVA_OPTS /app.jar

