name := "BackEnd"

version := "0.1"

scalaVersion := "2.12.8"

lazy val root = (project in file(".")).enablePlugins(PlayScala)


libraryDependencies ++= Seq("com.typesafe.slick" %% "slick" % "3.2.3")

libraryDependencies += guice

val circeVersion = "0.10.0"

libraryDependencies ++= Seq(
  "io.circe" %% "circe-core",
  "io.circe" %% "circe-generic",
  "io.circe" %% "circe-parser"
).map(_ % circeVersion)

libraryDependencies += "com.dripower" %% "play-circe" % "2610.0"

scalacOptions += "-Ypartial-unification"

libraryDependencies += "org.typelevel" %% "cats-core" % "1.5.0"

libraryDependencies ++= Seq(
  "org.scalikejdbc" %% "scalikejdbc"       % "3.3.2",
  "com.h2database"  %  "h2"                % "1.4.197",
  "ch.qos.logback"  %  "logback-classic"   % "1.2.3"
)