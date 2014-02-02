package org.jsantosp.akka.camel.cxf.weather

import org.scalatest.BeforeAndAfterAll
import org.scalatest.WordSpecLike
import org.scalatest.Matchers
import akka.actor.{ Actor, ActorRef, ActorSystem, Props }
import akka.testkit.{ TestKit }
import scala.concurrent.duration._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import scala.collection.JavaConversions._
import com.cdyne.ws._

@RunWith(classOf[JUnitRunner])
class Test1
  extends TestKit(ActorSystem("MyActorSystem"))
  with WordSpecLike with Matchers with BeforeAndAfterAll {

  override def afterAll {
    TestKit.shutdownActorSystem(system)
  }

  val myProducer = system.actorOf(Props[MyProducerActor])

  "A MyProducerActor" should {
    "get a propper response with GetWeatherInformation" in {

      val operation = "GetWeatherInformation"
      val params: java.util.List[String] = List()
      val request = WeatherMessage(params, Map(
        "operationName" -> operation,
        "soapAction" -> s"http://ws.cdyne.com/WeatherWS/$operation"))

      myProducer ! request
      Thread.sleep(2000)

    }
  }

  "A MyProducerActor" should {
    "get a propper response with GetCityWeatherByZIP" in {

      val operation = "GetCityWeatherByZIP"
      val params: java.util.List[String] = List("22313")
      val request = WeatherMessage(params, Map(
        "operationName" -> operation,
        "soapAction" -> s"http://ws.cdyne.com/WeatherWS/$operation"))

      myProducer ! request
      Thread.sleep(2000)

    }
  }

  "A MyProducerActor" should {
    "get a propper response with GetCityForecastByZIP" in {

      val operation = "GetCityForecastByZIP"
      val params: java.util.List[String] = List("22313")
      val request = WeatherMessage(params, Map(
        "operationName" -> operation,
        "soapAction" -> s"http://ws.cdyne.com/WeatherWS/$operation"))

      myProducer ! request
      Thread.sleep(2000)

    }
  }
}