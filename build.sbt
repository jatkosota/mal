name := "mal"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "org.scalaz" %% "scalaz-core" % "7.2.5",
  "org.scalatest" %% "scalatest" % "3.0.0" % "test"
)

scalacOptions in ThisBuild ++= Seq(
  "-feature"
)
