package supervisor

import scala.io.StdIn._
import scala.concurrent.Await
import scala.concurrent.duration._

import akka.actor.{
  ActorSystem,
  Kill,
  PoisonPill,
  Props
}
import akka.pattern.{
  AskTimeoutException,
  gracefulStop
}

import com.typesafe.scalalogging.LazyLogging

object Main extends App with LazyLogging {

  val system = ActorSystem("root")
  val actor = system.actorOf(Props(new Supervisor("Supervisor")))

  def loop(line: String): String = {
    line match {
      case "poison" =>
        actor ! PoisonPill
        "Begin PoisonPill"
      case "kill" =>
        actor ! Kill
        "Begin Kill"
      case _ =>
        println(s"Sending: ${line}")
        actor ! Some(line)
        loop(readLine())
    }
  }

  println("Start")
  loop(readLine())

  try {
    val stopped = gracefulStop(actor, 5.seconds, PoisonPill)
    Await.result(stopped, 6.seconds)
  } catch {
    case e: AskTimeoutException =>
      logger.error(e.getMessage)
  }

  system.terminate()
}
