name := "akka-camel-cxf-weather"

scalaVersion := "2.10.3"

libraryDependencies in ThisBuild <++= scalaVersion { (sv: String) => Seq(
	"com.typesafe.akka" %% "akka-actor" % "2.2.3",
	"com.typesafe.akka" %% "akka-testkit" % "2.2.3",
  "com.typesafe.akka" %% "akka-camel" % "2.2.3",
  "org.apache.camel" % "camel-core" % "2.12.2",
  "org.apache.camel" % "camel-cxf" % "2.12.2",
  "org.apache.camel" % "camel-http4" % "2.12.2",
	"org.scalatest" %% "scalatest" % "2.0" % "test",
	"junit" % "junit" % "4.10" % "test",
  "org.slf4j" % "slf4j-simple" % "1.7.5"
)}

resolvers += "Maven repository" at "http://central.maven.org/maven2/"