
# Etapa de Build

FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app

# Copia todos os arquivos
COPY . .

# Gera o JAR da aplicação
RUN mvn clean package -DskipTests


# Etapa de Runtime

FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copia o jar gerado
COPY --from=build /app/target/*.jar app.jar

# Porta do Spring Boot
EXPOSE 8080

# Perfil de produção
ENV SPRING_PROFILES_ACTIVE=prod

# Inicializa a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]