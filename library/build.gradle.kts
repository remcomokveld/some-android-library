plugins {
    id("com.android.library")
    `maven-publish`
}

android {
    compileSdk = 33
    defaultConfig {
        minSdk = 23
    }
    namespace = "dev.mokveld.some.library"
    publishing {
        singleVariant("release") {
            withJavadocJar()
            withSourcesJar()
        }
    }
}

publishing {
    publications {
        create<MavenPublication>("release") {
            afterEvaluate { from(components.getByName("release")) }
        }
    }
}