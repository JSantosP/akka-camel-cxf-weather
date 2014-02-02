package org.jsantosp.akka.camel.cxf.weather

import akka.actor.Actor
import akka.camel.{ CamelExtension, Producer }
import scala.collection.JavaConversions._
import com.cdyne.ws._

case class WeatherMessage(body: java.util.List[String], headers: java.util.Map[String, Object])

class MyProducerActor extends Actor {
  import helpers._

  val camel = CamelExtension(context.system)

  val uri = "cxf:http://wsf.cdyne.com/WeatherWS/Weather.asmx?" +
    "serviceClass=com.cdyne.ws.WeatherSoap"

  def receive = {

    case WeatherMessage(body, headers) =>
      camel.template.requestBodyAndHeaders(uri, body, headers) match {

        case Response(List(awd: ArrayOfWeatherDescription)) =>
          awd.getWeatherDescription().toList map format foreach println

        case Response(List(wr: WeatherReturn)) =>
          println(format(wr))

        case Response(List(fr: ForecastReturn)) =>
          println(format(fr))

        case response => println(response)

      }

    case _ => ()

  }

}