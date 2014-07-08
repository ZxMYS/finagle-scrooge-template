com.twitter.scrooge.ScroogeSBT.newSettings

scalaVersion := "2.10.1"

libraryDependencies ++= Seq(
"org.apache.thrift" % "libthrift" % "0.8.0",
"com.twitter" %% "scrooge-core" % "3.9.2",
"com.twitter" %% "finagle-thrift" % "6.5.0"
)

name := "quickstart"

version := "1.0"

libraryDependencies += "com.twitter" %% "finagle-http" % "6.2.0"

scalacOptions ++= Seq("-feature", "-language:higherKinds")

