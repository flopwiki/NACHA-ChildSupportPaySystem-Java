group = "org.nacha"
version = "1.0-SNAPSHOT"
description = "nacha-paymentsystem"

plugins {
    // Java plugin for building Java applications
    id("java")

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
    // JUnit 5 for unit testing
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.10.0")

    // Additional dependencies can go here (e.g., logging, database, etc.)
    implementation("org.owasp:dependency-check-gradle:10.0.2")
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
