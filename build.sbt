name := "gcgl2015"

version := "1.0-SNAPSHOT"

libraryDependencies ++= appDependencies

val appDependencies = Seq(
  jdbc,
  "org.squeryl" %% "squeryl" % "0.9.5-6"
)

libraryDependencies +=   "mysql" % "mysql-connector-java" % "5.1.21"

play.Project.playScalaSettings
