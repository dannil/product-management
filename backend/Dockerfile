FROM eclipse-temurin:21 AS builder
WORKDIR /opt/app
COPY . .
RUN ./mvnw package -DskipTests

FROM eclipse-temurin:21 AS runner
WORKDIR /opt/app
COPY --from=builder /opt/app/target/*.jar /opt/app/backend.jar
CMD ["java", "-jar", "/opt/app/backend.jar"]
