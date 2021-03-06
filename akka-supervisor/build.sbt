name := "akka-supervisor"

version := "0.0.1"

organization := "com.github.nabezokodaikon"

libraryDependencies ++= {
  val scalaTestVersion = "3.0.5"
  val akkaVersion = "2.5.18"
  val akkaHttpVersion = "10.1.5"
  Seq(
    // Logger
    "ch.qos.logback" % "logback-classic" % "1.2.3",
    "com.typesafe.scala-logging" %% "scala-logging" % "3.7.2",
    // Test
    "org.scalactic" %% "scalactic" % scalaTestVersion,
    "org.scalatest" %% "scalatest" % scalaTestVersion % "test",
    "org.scalacheck" %% "scalacheck" % "1.14.0" % "test",
    // Akka
    "com.typesafe.akka" %% "akka-actor" % akkaVersion,
    "com.typesafe.akka" %% "akka-testkit" % akkaVersion % Test,
    "com.typesafe.akka" %% "akka-stream" % akkaVersion,
    "com.typesafe.akka" %% "akka-stream-testkit" % akkaVersion % Test,
    "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
    "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpVersion % Test,
    "com.softwaremill.akka-http-session" %% "core" % "0.5.6",
  )
}

initialCommands in console := "import supervisor._"
