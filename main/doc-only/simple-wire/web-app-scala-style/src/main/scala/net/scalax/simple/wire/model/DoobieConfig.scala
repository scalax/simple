package net.scalax.simple.wire
package model

case class EnvName(EnvA: String, EnvB: String)

case class EnvDoobie(name: EnvName)

case class EnvSum(doobie: EnvDoobie)

case class ProjectConfig2(wire: EnvSum)
case class SimpleProjectConfig(simple: ProjectConfig2)
