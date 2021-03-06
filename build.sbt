name := """api"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.12.6"

crossScalaVersions := Seq("2.11.12", "2.12.4")

libraryDependencies += guice

// Test Database
libraryDependencies += "com.h2database" % "h2" % "1.4.197"

// Testing libraries for dealing with CompletionStage...
libraryDependencies += "org.assertj" % "assertj-core" % "3.6.2" % Test
libraryDependencies += "org.awaitility" % "awaitility" % "2.0.0" % Test
libraryDependencies += "com.fasterxml.jackson.module" % "jackson-module-scala" % "2.0.2"
libraryDependencies ++= Seq(
  "org.webjars" % "bootstrap" % "3.3.7")
libraryDependencies +=   "org.avaje" % "ebean" % "2.8.1"
libraryDependencies += "org.webjars" % "jquery" % "2.1.4"

// Make verbose tests
testOptions in Test := Seq(Tests.Argument(TestFrameworks.JUnit, "-a", "-v"))

includeFilter in (Assets, LessKeys.less) := "*.less"
