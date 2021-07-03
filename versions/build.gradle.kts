plugins {
    `version-catalog`
    `maven-publish`
}

version = "latest"

catalog {
    versionCatalog {
        from(file("versions.toml"))
    }
}

publishing {
    publications {
        create<MavenPublication>("versions") {
            from(components["versionCatalog"])
        }
    }
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/OpenRedstoneEngineers/kOREUtils")
            credentials {
                username = System.getenv("GITHUB_ACTOR")
                password = System.getenv("GITHUB_TOKEN")
            }
        }
    }
}
