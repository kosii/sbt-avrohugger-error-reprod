name := "sbt-avrohugger-error-reprod"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies += "org.apache.avro" % "avro" % "1.8.1"

sbtavrohugger.SbtAvrohugger.specificAvroSettings

import sbtavrohugger.AvrohuggerSettings.avroScalaCustomNamespace

(avroScalaCustomNamespace in sbtavrohugger.SbtAvrohugger.avroConfig) := Map("foo" -> "foo.scala")
