FROM amazoncorretto:21
EXPOSE 8080:8080
RUN mkdir /app
COPY ./build/libs/*-all.jar /app/mainapp.jar
WORKDIR /app
ENTRYPOINT ["java","-jar","/app/mainapp.jar"]