name := "mal"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "org.scalaz" %% "scalaz-core" % "7.2.5",
  "org.scalatest" %% "scalatest" % "3.0.0" % "test",
  "com.lihaoyi" %% "fastparse" % "0.4.1"
)

scalacOptions in ThisBuild ++= Seq(
  "-feature"
)

initialCommands in console :=
  "import fastparse.all._, scalaz._, Scalaz._" ++
  ", jatkosota.mal.Parser._"
