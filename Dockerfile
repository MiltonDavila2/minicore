# Usa una imagen oficial de Maven para compilar la app
FROM maven:3.9.6-eclipse-temurin-21 AS build

# Crea el directorio de trabajo
WORKDIR /app

# Copia el pom.xml y descarga dependencias (optimiza cache)
COPY pom.xml .
RUN mvn dependency:go-offline

# Copia el resto del código fuente
COPY src ./src

# Compila el proyecto y empaqueta el JAR
RUN mvn clean package -DskipTests

# Usa una imagen ligera de Java para ejecutar la app
FROM eclipse-temurin:21-jdk-alpine

# Directorio de trabajo para la app
WORKDIR /app

# Copia el JAR desde el build anterior
COPY --from=build /app/target/minicore-0.0.1-SNAPSHOT.jar app.jar

# Puerto en el que correrá Spring Boot
EXPOSE 8080

# Comando de inicio
ENTRYPOINT ["java", "-jar", "app.jar"]