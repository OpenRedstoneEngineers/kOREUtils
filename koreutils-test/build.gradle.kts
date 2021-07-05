plugins {
    kotlin("jvm") version "1.5.0"
    `maven-publish`
}

repositories {
    mavenCentral()
}

publishing {
    publications {
        create<MavenPublication>("test") {
            from(components["java"])
        }
    }
}
