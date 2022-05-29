import Dependencies._

ThisBuild / scalaVersion     := "2.12.8"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.fsis"
ThisBuild / organizationName := "fsis"

resolvers ++= Seq(
  "Sonatype Public" at "https://oss.sonatype.org/content/groups/public/",
  "binary/non" at "https://dl.bintray.com/non/maven"
)
resolvers += Resolver.sonatypeRepo("releases")

addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.1" cross CrossVersion.full)
addCompilerPlugin("org.typelevel" % "kind-projector" % "0.13.2" cross CrossVersion.full)

val initialConsoleCommands = "import fsis._"

lazy val root = (project in file("."))
  .settings(
    name := "fam",
    libraryDependencies += scalaTest % Test,
    libraryDependencies += "com.github.mpilquist" %% "simulacrum" % "0.12.0",
    initialCommands / console := initialConsoleCommands
  )
