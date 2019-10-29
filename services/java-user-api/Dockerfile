FROM library/openjdk:11-slim
EXPOSE $PORT
#RUN apt-get update && \
#    apt-get install -y \
#        curl && \
#    rm -rf /var/lib/apt/lists/*
COPY target/java-user-api-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT exec java -Xms724m -Xmx724m -jar $JAVA_OPTS /app.jar

