plugins {
    `version-catalog`
    `maven-publish`
}

group = "org.openredstone"
version = "master-SNAPSHOT"

catalog {
    versionCatalog {
        version("ktor", "1.6.1")
        version("serialization", "1.2.1")
        version("coroutines", "1.5.0")
        alias("bungee-api").to("net.md-5:bungeecord-api:1.16-R0.5-SNAPSHOT")
        alias("spigot-api").to("org.spigotmc:spigot-api:1.16.2-R0.1-SNAPSHOT")

        fun bunch(group: String, prefix: String, versionRef: String, vararg modules: String) {
            modules.forEach { module ->
                val artifact = "$prefix-$module"
                alias(artifact).to(group, artifact).versionRef(versionRef)
            }
        }

        bunch(
            group = "org.jetbrains.kotlinx",
            prefix = "kotlinx-serialization",
            versionRef = "serialization",
            "core", "cbor"
        )

        alias("kotlinx-coroutines-core").to("org.jetbrains.kotlinx", "kotlinx-coroutines-core").versionRef("coroutines")

        bunch(
            group = "io.ktor",
            prefix = "ktor",
            versionRef = "ktor",
            "server-core", "server-netty", "serialization", "auth", "client-apache", "html-builder", "locations"
        )
    }
}

publishing {
    publications {
        create<MavenPublication>("versions") {
            from(components["versionCatalog"])
        }
    }
}

// temporary

tasks.register("clean") {}
tasks.register("build") {
    dependsOn("generateCatalogAsToml")
}
