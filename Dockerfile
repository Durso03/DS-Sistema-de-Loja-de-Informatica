# Etapa de build com Java 21 e Maven
FROM ubuntu:latest AS build

ENV DEBIAN_FRONTEND=noninteractive

RUN apt-get update && \
    apt-get install -y wget gnupg2 software-properties-common

# Adiciona o repositório do Eclipse Temurin para Java 21
RUN wget -O- https://packages.adoptium.net/artifactory/api/gpg/key/public | gpg --dearmor > /etc/apt/trusted.gpg.d/adoptium.gpg && \
    add-apt-repository --yes https://packages.adoptium.net/artifactory/deb jammy main && \
    apt-get update && \
    apt-get install -y temurin-21-jdk maven

WORKDIR /app

COPY . .

RUN mvn clean install -DskipTests

# Etapa de runtime com Java 21
FROM eclipse-temurin:21-jdk-jammy

WORKDIR /app

EXPOSE 8080

COPY --from=build /app/target/prova-20233008664-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]