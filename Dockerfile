FROM maven:3.8.6-jdk-11
WORKDIR /app/source
COPY . .
RUN mvn clean install -DskipTests

CMD mvn spring-boot:run