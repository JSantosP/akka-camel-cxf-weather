package weatherws

import org.scalatest.BeforeAndAfterAll
import org.scalatest.WordSpecLike
import org.scalatest.Matchers
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import akka.actor.{ Actor, ActorRef, ActorSystem, Props }
import akka.testkit.{ TestActorRef, TestProbe, TestKit }
import scala.concurrent.duration._
import scala.collection.JavaConversions._
import com.cdyne.ws._
import helpers._

@RunWith(classOf[JUnitRunner])
class Test1
  extends TestKit(ActorSystem("MyActorSystem"))
  with WordSpecLike with Matchers with BeforeAndAfterAll {

  val timeout = 10 seconds

  override def afterAll {
    TestKit.shutdownActorSystem(system)
  }

  val responseMailbox = TestProbe()

  val myProducer = system.actorOf(Props(new MyProducerActor(responseMailbox.ref)))

  "A MyProducerActor" should {
    "get a propper response with GetWeatherInformation" in {

      val operation = "GetWeatherInformation"
      val params: java.util.List[String] = List()
      val request = WeatherMessage(params, Map(
        "operationName" -> operation,
        "soapAction" -> s"http://ws.cdyne.com/WeatherWS/$operation"))

      println(system)
      myProducer ! request
      val Seq(response: ArrayOfWeatherDescription) = responseMailbox.receiveN(1, timeout)
      response.getWeatherDescription().toList map format foreach println

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
      val Seq(response: WeatherReturn) = responseMailbox.receiveN(1, timeout)
      println(format(response))

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
      val Seq(response: ForecastReturn) = responseMailbox.receiveN(1, timeout)
      println(format(response))

    }
  }
}