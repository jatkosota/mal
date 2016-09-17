package jatkosota.mal

object step0_repl extends App {

  def READ(str: String): String = str

  def EVAL(str: String, env: String): String = str

  def REP(str: String): String = str

  def readLine(): Unit =
    try {
      Option(scala.io.StdIn.readLine("user> ")) match {
        case Some(line) =>
          println(REP(line))
          readLine()
        case None =>
      }
    } catch {
      case e: Exception =>
        println("Error: " + e.getMessage)
        println("    " + e.getStackTrace.mkString("\n    "))
    }

  readLine()
}
