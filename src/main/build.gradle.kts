group = "org.nacha"
version = "1.0-SNAPSHOT"
description = "nacha-paymentsystem"

plugins {
    id("org.springframework.boot") version "3.3"
    id("io.spring.dependency-management") version "1.1.6"
    // Java plugin for building Java applications
    id("java")
    id("jacoco")


    // Apply application plugin if you're building an executable app
    application
    // implementation
}
java {
    // Set Java 21 as the source and target compatibility
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}




repositories {
    // Use Maven Central repository to resolve dependencies
    mavenCentral()
}

dependencies {

    // Spring boot starter
    implementation("org.springframework.boot:spring-boot-starter-web")

    // JUnit 5 for unit testing
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.10.0")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.0")

    // Additional dependencies can go here (e.g., logging, database, etc.)
    implementation("org.owasp:dependency-check-gradle:10.0.2")

    // Spring Boot Starter Web for RESTful APIs
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    // Spring Boot Starter Data JPA for database persistence (Hibernate/JPA)
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    // Spring Boot Starter Test for JUnit and Mockito testing
    testImplementation("org.springframework.boot:spring-boot-starter-test")


    // Database connector (for example, H2 in-memory database for development/testing)
    runtimeOnly("com.h2database:h2")

    // Optional: Spring Boot Starter Security if you're using Spring Security
    implementation("org.springframework.boot:spring-boot-starter-security")

    // Optional: If using RabbitMQ or Kafka for messaging
    implementation("org.springframework.boot:spring-boot-starter-amqp") // RabbitMQ
    // implementation("org.springframework.kafka:spring-kafka") // Uncomment for Kafka

    // Logging (if not using Logback XML)
    implementation("org.slf4j:slf4j-api:2.0.9")
    runtimeOnly("ch.qos.logback:logback-classic:1.4.11")

    // Kotlin extensions if needed (optional)
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
}

tasks.test {
    // Enable JUnit Platform (for JUnit 5)
    useJUnitPlatform()
}

application {
    // Define the main class for the application (replace with your main class)
    mainClass.set("org.nacha.paymentsystem.Main")  // Adjust this to the actual package and class name
}

tasks.withType<JavaCompile> {
    // Set compiler options if needed (optional)
    options.encoding = "UTF-8"
    options.release.set(21) // Ensure compatibility with Java 21
}
