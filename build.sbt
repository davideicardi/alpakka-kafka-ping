name := "alpakka-kafka-ping"

version := "0.1"

scalaVersion := "2.12.6"

val akkaVersion = "2.5.14"
val log4jVersion = "2.11.1"

libraryDependencies ++= Seq(
"com.typesafe.akka" %% "akka-actor" % akkaVersion,
"com.typesafe.akka" %% "akka-stream" % akkaVersion,
"com.lightbend.akka" %% "akka-stream-alpakka-mqtt" % "0.20",
"com.typesafe.akka" %% "akka-stream-kafka" % "0.22",
"org.slf4j" % "slf4j-api" % "1.7.25",
"com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
"org.apache.logging.log4j" % "log4j-slf4j-impl" % log4jVersion,
"org.apache.logging.log4j" % "log4j-api" % log4jVersion,
"org.apache.logging.log4j" % "log4j-core" % log4jVersion
)


enablePlugins(JavaServerAppPackaging)