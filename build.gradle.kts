import org.gradle.api.JavaVersion.VERSION_1_8

plugins {
  id("fabric-loom") version "0.2.0-SNAPSHOT"
}

base {
  archivesBaseName = "qcommon-croco"
}

group = "therealfarfetchd.qcommon.croco"
version = "1.0.5"

apply(from = "https://raw.githubusercontent.com/therealfarfetchd/gradle-tools/master/publish.gradle")

java {
  sourceCompatibility = VERSION_1_8
  targetCompatibility = VERSION_1_8
}

minecraft {
}

dependencies {
  minecraft("com.mojang:minecraft:19w11b")
  mappings("net.fabricmc:yarn:19w11b.4")
  modCompile("net.fabricmc:fabric-loader:0.3.7.109")

  // Fabric API. This is technically optional, but you probably want it anyway.
  modCompile("net.fabricmc:fabric:0.2.3.111")

  compile("com.google.code.findbugs:jsr305:3.0.2")
}
