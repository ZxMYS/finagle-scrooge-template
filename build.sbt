com.twitter.scrooge.ScroogeSBT.newSettings

resolvers += "twitter" at "http://maven.twttr.com/"

scalaVersion := "2.10.1"

conflictWarning in ThisBuild := ConflictWarning.disable

libraryDependencies ++= Seq(
"org.apache.thrift" % "libthrift" % "0.8.0",
"com.twitter" %% "scrooge-core" % "3.9.2",
"com.twitter" %% "finagle-thrift" % "6.6.2"
)

name := "FinagleScroogeTemplate"

version := "1.0"

libraryDependencies += "com.twitter" %% "finagle-stats" % "6.6.2"

libraryDependencies += "com.twitter" %% "finagle-ostrich4" % "6.6.2"

libraryDependencies += "com.twitter" %% "util" % "6.18.0"

libraryDependencies += "com.twitter" %% "util-core" % "6.18.0"

libraryDependencies += "com.twitter" %% "util-eval" % "6.18.0"

libraryDependencies += "com.twitter" % "json" % "2.1.4"

scalacOptions ++= Seq("-feature", "-language:higherKinds", "-deprecation")

