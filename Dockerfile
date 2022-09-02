FROM azul/zulu-openjdk:18
WORKDIR /app
COPY ./build/libs/bms-0.1-all.jar .
EXPOSE 8080

CMD ["java", "-jar", "bms-0.1-all.jar"]