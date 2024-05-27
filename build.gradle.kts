plugins {
    id("java")
    id("idea")
    id("org.springframework.boot") version "3.3.0"
    id("io.spring.dependency-management") version "1.1.5"
}

tasks.wrapper {
    distributionType = Wrapper.DistributionType.ALL
    gradleVersion = "8.7"
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

idea {
   module {
       isDownloadSources = true
       isDownloadJavadoc = true
   }
}

repositories {
    mavenCentral()
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

dependencies {

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    runtimeOnly("com.h2database:h2")

    // swagger
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.5.0")

    // Hazelcast
    implementation("com.hazelcast:hazelcast:5.4.0")
    implementation("com.hazelcast:hazelcast-hibernate53:5.1.0")
    implementation("com.hazelcast:hazelcast-spring:5.4.0")

    // lombok
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
    useJUnitPlatform()
}