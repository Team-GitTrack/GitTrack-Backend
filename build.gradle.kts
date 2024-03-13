import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version PluginVersions.SPRING_BOOT_FRAMEWORK_VERSION
    id("io.spring.dependency-management") version PluginVersions.SPRING_DEPENDENCY_MANAGEMENT_VERSION
    kotlin("jvm") version PluginVersions.JVM_VERSION
    kotlin("plugin.spring") version PluginVersions.PLUGIN_SPRING_VERSION
    kotlin("plugin.jpa") version PluginVersions.PLUGIN_JPA_VERSION
}

group = "juyeong"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(Dependencies.JPA)
    implementation(Dependencies.SECURITY)
    implementation(Dependencies.VALIDATION)
    implementation(Dependencies.WEB)
    implementation(Dependencies.JACKSON)
    implementation(Dependencies.REFLECT)
    implementation(Dependencies.JDK8)
    implementation(Dependencies.JWT)
    runtimeOnly(Dependencies.MYSQL)
    implementation(Dependencies.REDIS)
    implementation(Dependencies.CLOUD_AWS)
    annotationProcessor(Dependencies.CONFIGURATION_PROCESSOR)
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.MappedSuperclass")
    annotation("javax.persistence.Embeddable")
}

tasks.getByName<Jar>("jar") {
    enabled = false
}

configurations {
    create("myConfiguration") {
        isCanBeResolved = true
        isCanBeConsumed = false
    }
}
