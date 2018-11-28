import Dependencies._

val appVersion = sys.env.get("TRAVIS_TAG") orElse sys.env.get("BUILD_LABEL") getOrElse s"1.0.0-${System.currentTimeMillis / 1000}-SNAPSHOT"

lazy val commonSettings = Seq(
  organization := "com.stacktoheap",
  version := appVersion,
  scalaVersion := "2.11.11",
  unmanagedBase := file(".") / "lib",
  libraryDependencies ++= Seq(
    sparkStreaming, scalaTest
  ),
  javacOptions ++= Seq("-source", "1.8", "-target", "1.8"),
  crossPaths := false,
  assemblyOption in assembly := (assemblyOption in assembly).value.copy(includeScala = false)
)

lazy val core = (project in file("pipedream-core")).
  settings(commonSettings: _*).
  settings(
    name := "pipedream-core",
  )

lazy val root = Project(
  id = "pipedream",
  base = file(".")
) aggregate(core)
