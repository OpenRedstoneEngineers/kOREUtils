plugins {
    `maven-publish`
    `kotlin-dsl`
}

group = "org.openredstone"
version = "master-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("script-runtime"))
}
