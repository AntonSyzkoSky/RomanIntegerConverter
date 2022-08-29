plugins {
    java
}

group = "com.roman.converter"
version = "1.0-SNAPSHOT"

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.0"))
    testImplementation(platform("io.cucumber:cucumber-bom:7.6.0"))

    testImplementation("io.cucumber:cucumber-java")
    testImplementation("io.cucumber:cucumber-junit-platform-engine")
    testImplementation("org.junit.platform:junit-platform-suite")
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation ("org.assertj:assertj-core:3.21.0")
}

repositories {
    mavenLocal()
    mavenCentral()
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}