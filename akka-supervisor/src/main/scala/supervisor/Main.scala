package supervisor

import scala.io.StdIn._

import com.typesafe.scalalogging.LazyLogging

object Main extends App with LazyLogging {

  def loop(line: String): String = {
    line match {
      case "q" =>
        println("Exit")
        "exist"
      case _ =>
        // actor ! line
        loop(readLine())
    }
  }

  logger.info("Start")
  loop(readLine())
}
