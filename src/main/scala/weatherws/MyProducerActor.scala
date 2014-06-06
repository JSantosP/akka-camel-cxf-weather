package weatherws

import akka.actor.{Actor,ActorRef}
import akka.camel.{ CamelExtension, Producer }
import scala.collection.JavaConversions._
import com.cdyne.ws._

/** Special type of message for requesting weather information to WS.*/
case class WeatherMessage(body: java.util.List[String], headers: java.util.Map[String, Object])

/** 
  * This actor receives ws requests and forward them to camel endpoint, waiting for results.
  */
class MyProducerActor(responseMail: ActorRef) extends Actor {
  import helpers._

  val camel = CamelExtension(context.system)

  val uri = "cxf:http://wsf.cdyne.com/WeatherWS/Weather.asmx?" +
    "serviceClass=com.cdyne.ws.WeatherSoap"

  def receive = {

    case WeatherMessage(body, headers) =>
      camel.template.requestBodyAndHeaders(uri, body, headers) match {

        case Response(List(awd: ArrayOfWeatherDescription)) => responseMail ! awd

        case Response(List(wr: WeatherReturn)) => responseMail ! wr

        case Response(List(fr: ForecastReturn)) => responseMail ! fr

      }

  }

}