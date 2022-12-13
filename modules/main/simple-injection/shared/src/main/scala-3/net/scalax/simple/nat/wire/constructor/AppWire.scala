package net.scalax.simple.nat.wire
package constructor

import service.{ServiceA, ServiceAImpl, ServiceB, ServiceBImpl}
import routes.{NatHttpRoutes, NatHttpRoutesImpl}
import org.http4s.HttpRoutes
import cats.effect._

class AppWire:

  private given ServiceA              = new ServiceAImpl(() => serviceB)
  private lazy val serviceB: ServiceB = new ServiceBImpl(() => summon)

  private lazy val natRoutesInstances: NatHttpRoutes = new NatHttpRoutesImpl
  lazy val routes: HttpRoutes[IO]                    = natRoutesInstances.route

end AppWire
