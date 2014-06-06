akka-camel-cxf-weather
======================

[![Build Status](https://travis-ci.org/JSantosP/akka-camel-cxf-weather.svg?branch=master)](https://travis-ci.org/JSantosP/akka-camel-cxf-weather)

This is an example of how to integrate akka-camel and cxf in order to connect with Weather web services.

Weather WS is described at [Weather Web Service](http://wsf.cdyne.com/WeatherWS/Weather.asmx)

Java classes were generated using `apache-cxf` tool `wsdl2java` from weather wsdl file (located at `res/Weather.wsdl`).
It can be used this way:

 > `wsdl2java -client -d <output_directory> -p <package_name> -autoNameResolution <wsdl_file>`

Once these JAXB-annotated Java classes are generated, a CamelProducer is defined using akka-camel module:

```scala
class MyProducerActor extends Actor {

  val camel = CamelExtension(context.system)

  val uri = "cxf:http://some.uri.with.ws"

  def receive = {

    case Request(body, headers) =>
      camel.template.requestBodyAndHeaders(uri, body, headers) match {

        case response => println(response)

      }

  }

}
```

And now you can send requests via message to this actor and it will forward them to camel for routing and processing both the request and possibly response.

You can get extra information at:
* [Akka-camel](http://doc.akka.io/docs/akka/2.2.3/scala/camel.html)
* [Wsdl2Java](http://cxf.apache.org/docs/wsdl-to-java.html)
* [Camel in action (Manning) - Chapter 7.4](http://www.manning.com/ibsen/)
* [Camel cxf](http://camel.apache.org/cxf.html)
