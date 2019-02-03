import org.gradle.api.JavaVersion.VERSION_1_8

plugins {
  id("fabric-loom") version "0.2.0-SNAPSHOT"
}

base {
  archivesBaseName = "qcommon-croco"
}

group = "therealfarfetchd.qcommon.croco"
version = "1.0.4"

java {
  sourceCompatibility = VERSION_1_8
  targetCompatibility = VERSION_1_8
}

minecraft {
}

dependencies {
  minecraft("com.mojang:minecraft:18w50a")
  mappings("net.fabricmc:yarn:18w50a.73")
  modCompile("net.fabricmc:fabric-loader:0.3.0.77")

  // Fabric API. This is technically optional, but you probably want it anyway.
  modCompile("net.fabricmc:fabric:0.1.2.64")

  compile("com.google.code.findbugs:jsr305:3.0.2")
}
