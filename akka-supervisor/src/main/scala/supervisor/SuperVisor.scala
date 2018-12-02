package supervisor

import akka.actor.{
  Actor,
  Terminated
}

class Supervisor(actorName: String) extends Actor {

  println(s"Supervisor: Constructor args: ${actorName}")

  override def preStart(): Unit = {
    println("Supervisor: preStart")
  }

  override def postStop(): Unit = {
    println("Supervisor: postStop")
  }

  override def preRestart(reason: Throwable, message: Option[Any]): Unit = {
    println("Supervisor: preRestart")
  }

  override def postRestart(reason: Throwable): Unit = {
    println("Supervisor: postRestart")
  }

  def receive = {
    // 子アクター？
    // case Terminated(`self`) =>
    // println("Terminated")
    // println(`self`)
    case Some(msg) =>
      println(s"Supervisor received: ${msg}")
  }
}
