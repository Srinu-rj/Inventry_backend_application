FROM eclipse-temurin:25-jdk-jammy AS builder
WORKDIR /build
COPY gradlew .
COPY gradle/ gradle/
COPY build.gradle .
COPY settings.gradle .
RUN ./gradlew dependencies --no-daemon
COPY src/ src/
RUN ./gradlew build --no-daemon -x test

FROM eclipse-temurin:25-jre-alpine
WORKDIR /app
COPY --from=builder /build/build/libs/*.jar /tenantapplication.jar
EXPOSE 1199
ENTRYPOINT ["java", "-jar", "/tenantapplication.jar"]



# FROM eclipse-temurin:25-jdk-jammy AS builder
# WORKDIR /build
# COPY build.gradle .
# COPY settings.gradle .
# COPY src/ src/
#
# RUN ./gradlew build --no-daemon
#
# FROM eclipse-temurin:25-jre-alpine
# COPY build/libs/*.jar /tenantapplication.jar
# EXPOSE 1199
# ENTRYPOINT ["java", "-jar", "/tenantapplication.jar"]