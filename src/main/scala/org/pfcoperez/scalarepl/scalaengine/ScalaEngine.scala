package org.pfcoperez.scalarepl.scalaengine

import scala.util.Try

trait ScalaEngine {

  def runCode(code: String): (ScalaEngine, Try[Any])

}
