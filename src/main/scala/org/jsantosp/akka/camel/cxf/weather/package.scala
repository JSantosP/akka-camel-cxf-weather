package org.jsantosp.akka.camel.cxf.weather

import org.apache.cxf.message.MessageContentsList
import scala.collection.JavaConversions._
import com.cdyne.ws._

object `package` {

  object helpers {

    object Response {
      def unapply(obj: Object): Option[List[Any]] =
        try {
          Some(obj.asInstanceOf[MessageContentsList].toArray.toList)
        } catch {
          case _: Throwable => None
        }

    }

    def format(wd: WeatherDescription): String =
      s"[${wd.getWeatherID()}," +
        s"${wd.getPictureURL()}," +
        s"${wd.getDescription()}]"

    def format(wr: WeatherReturn): String =
      s"[${wr.getWeatherID}," +
        s"${wr.getWeatherStationCity}," +
        s"${wr.getCity}," +
        s"${wr.getDescription}," +
        s"${wr.getPressure}," +
        s"${wr.getRelativeHumidity}," +
        s"${wr.getRemarks}," +
        s"${wr.getResponseText}," +
        s"${wr.getState}," +
        s"${wr.getTemperature}," +
        s"${wr.getVisibility}," +
        s"${wr.getWind}," +
        s"${wr.getWindChill}]"

    def format(fr: ForecastReturn): String =
      s"[${fr.getCity}," +
        s"${fr.getWeatherStationCity}," +
        s"${fr.getResponseText}," +
        s"${fr.getState},${
          fr.getForecastResult.getForecast.toList.map(f => format(f)).mkString("\n\t")
        }]"

    def format(f: Forecast): String =
      s"[${f.getWeatherID}," +
        s"${f.getDesciption}," +
        s"${f.getDate}," +
        s"${f.getProbabilityOfPrecipiation.getDaytime}," +
        s"${f.getProbabilityOfPrecipiation.getNighttime}," +
        s"${f.getTemperatures.getMorningLow}," +
        s"${f.getTemperatures.getDaytimeHigh}]"

  }

}