package tdm

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder

import scala.concurrent.duration.{FiniteDuration, SECONDS}

class TdmSimulation extends Simulation {

  private val headers = Map("Content-Type" -> "application/json")

  val httpProtocol: HttpProtocolBuilder = http
    .baseUrl("http://localhost:8080/api/v1")

  val getMoves: ScenarioBuilder = scenario("Get all moves")
    .exec(http("Get all customers")
      .get("/customers")
    .check(status.is(200)))
    .pause(3,4)

    .exec(http("Get all empoyees")
      .get("/employees")
    .check(status.is(200)))
    .pause(3,4)

    .exec(http("Get all offices")
      .get("/offices")
    .check(status.is(200)))
    .pause(3,4)

    .exec(http("Get all orders")
      .get("/orders")
      .check(status.is(200)))
    .pause(3,4)

    .exec(http("Get all products")
      .get("/products")
      .check(status.is(200)))
    .pause(3,4)

  setUp(getMoves.inject(
    constantUsersPerSec(1) during (FiniteDuration(10, SECONDS)))
    .protocols(httpProtocol))
}