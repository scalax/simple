import Settings._
import ProjectKeys._
import sbt.Project.projectToLocalProject
import sbtcrossproject.Platform

import scala.collection.compat._

common.collect

val testCommon = crossProject(JSPlatform, JVMPlatform).in(file(".") / "test-common")

val currentPro = settingKey[Project]("Current Pro")
/*currentPro:={
  val plat = (Test/currentPlatform).value
  projectToLocalProject(testCommon.projects(plat))
}*/

def addToCoreProject(p: Project, platform: Platform) = {
  /*val s1 = Test/currentPlatform := platform
  val s2 = Test / crossDepts := {
    Seq((currentPro.value/projectID).value)
  }
  Seq(s1,s2)*/
  Seq.empty
}

testCommon.projects.to(List).flatMap{case(s,t)=>addToCoreProject(t,s)}