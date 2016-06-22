name := "spark-indexedrdd"

version := "0.3"

organization := "edu.berkeley.cs.amplab"

scalaVersion := "2.10.4"

spName := "amplab/spark-indexedrdd"

sparkVersion := "1.5.0"

sparkComponents += "core"

publishMavenStyle := true

licenses += "Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0.html")

pomExtra := (
  <url>https://github.com/amplab/spark-indexedrdd</url>
  <scm>
    <url>git@github.com:amplab/spark-indexedrdd.git</url>
    <connection>scm:git:git@github.com:amplab/spark-indexedrdd.git</connection>
  </scm>
  <developers>
    <developer>
      <id>ankurdave</id>
      <name>Ankur Dave</name>
      <url>https://github.com/ankurdave</url>
    </developer>
  </developers>)

libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.4" % "test"

libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.12.2" % "test"

resolvers += "Repo at github.com/ankurdave/maven-repo" at "https://raw.githubusercontent.com/ankurdave/maven-repo/master"

libraryDependencies += "com.ankurdave" %% "part" % "0.1"

// Run tests with more memory
javaOptions in test += "-Xmx2G"

fork in test := true

excludedJars in assembly := {
  val cp = (fullClasspath in assembly).value
  cp filter {_.data.getName == "scala-library.jar"}
}
