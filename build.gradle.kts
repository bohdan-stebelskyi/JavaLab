plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.testng:testng:7.8.0")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.15.2")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.15.2")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.5.21")
    implementation("javax.validation:validation-api:2.0.1.Final")
    implementation("org.hibernate.validator:hibernate-validator:6.2.0.Final")
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.5.21")
    implementation("org.springframework.boot:spring-boot-starter-validation:2.6.1")
    implementation("mysql:mysql-connector-java:8.0.33")
    implementation("javax.servlet:javax.servlet-api:4.0.1")
}

tasks.test {
    useJUnitPlatform()
}

tasks.test{
    useTestNG()
}