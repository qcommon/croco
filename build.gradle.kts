plugins {
  id("fabric-loom") version "0.1.0-SNAPSHOT"
  id("com.jaredsburrows.checkerframework") version "0.2.2"
}

base {
  archivesBaseName = "qcommon-croco"
}

group = "therealfarfetchd.qcommon.croco"
version = "1.0.3"

minecraft {
}

dependencies {
  minecraft("com.mojang:minecraft:18w50a")
  mappings("net.fabricmc:yarn:18w50a.20")
  modCompile("net.fabricmc:fabric-loader:0.2.0.70")

  // Fabric API. This is technically optional, but you probably want it anyway.
  modCompile("net.fabricmc:fabric:0.1.1.52")
}
