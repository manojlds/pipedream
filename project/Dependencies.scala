import sbt._

object Dependencies {

  lazy val sparkStreaming = "org.apache.spark" %% "spark-streaming" % "2.4.0"
  lazy val sparkStreamingKafka = "org.apache.spark" %% "spark-streaming-kafka-0-10" % "2.4.0"
  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.0.5" % Test
}
