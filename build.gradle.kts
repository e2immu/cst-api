/*
 * Copyright (c) 2022-2023, CodeLaser BV, Belgium.
 * Unauthorized copying of this file, via any medium, is strictly prohibited.
 * Proprietary and confidential.
 */

plugins {
    java
    id("maven-publish")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
    withSourcesJar()
}

dependencies {
    implementation(project(":support"))

    implementation(libs.e2immuSupport)
    implementation(libs.e2immuGraph)
   // implementation(libs.e2immuAnalyser)
  //  implementation(libs.e2immuAnalyserCli)
  //  implementation(libs.e2immuAnalyserUtil)
    implementation(libs.slf4jApi)
    implementation(libs.jgraphtCore)
    implementation(libs.jgraphtIO)
    implementation(libs.logbackClassic)
    implementation(libs.guava)
    implementation(libs.javaParser)
    implementation(libs.yaml)

    testImplementation(libs.httpClient5)
    testImplementation(libs.httpCore5)
    testImplementation(libs.junitJupiterApi)
    testRuntimeOnly(libs.junitJupiterEngine)
}

tasks.test {
    useJUnitPlatform()

    maxHeapSize ="2G"
    exclude( "**/failing/*")
    maxParallelForks = 8
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])

            pom {
                name = "JFocus Standardize"
                description = "JFocul Standardize"
                url = "https://codelaser.io"
                licenses {
                    license {
                        name = "Commercial. Contact CodeLaser BV, Bazel, Belgium."
                    }
                }
                developers {
                    developer {
                        id = "bnaudts"
                        name = "Bart Naudts"
                        email = "bart.naudts@codelaser.io"
                    }
                }
            }
        }
    }
}


