addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "1.3.6")

// resolve plugin dependencies conflict
dependencyOverrides += "org.codehaus.plexus" % "plexus-utils" % "3.0.17"
dependencyOverrides += "com.google.guava" % "guava" % "20.0"
