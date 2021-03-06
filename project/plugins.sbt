addSbtPlugin("io.get-coursier" % "sbt-coursier" % "1.0.0-RC10")
addSbtPlugin("org.scala-js" % "sbt-scalajs" % "0.6.20")
addSbtPlugin("pl.project13.scala" % "sbt-jmh" % "0.2.27")
addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.14.5")
addSbtPlugin("com.eed3si9n" % "sbt-buildinfo" % "0.7.0")
addSbtPlugin("com.lucidchart" % "sbt-scalafmt-coursier" % "1.10")
addSbtPlugin("com.typesafe.sbt" % "sbt-git" % "0.9.3")
addSbtPlugin("com.jsuereth" % "sbt-pgp" % "1.1.0-M1")
addSbtPlugin("org.xerial.sbt" % "sbt-sonatype" % "2.0")

resolvers += Resolver.sonatypeRepo("snapshots")
addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.5.1-SNAPSHOT")
