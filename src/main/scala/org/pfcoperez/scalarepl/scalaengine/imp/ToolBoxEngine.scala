package org.pfcoperez.scalarepl.scalaengine.imp

import scala.tools.reflect.ToolBox
import scala.reflect.runtime.universe

import org.pfcoperez.scalarepl.scalaengine.ScalaEngine

import scala.util.Try

object ToolBoxEngine {
  def apply(): ToolBoxEngine =
    new ToolBoxEngine(
      Nil,
      universe.runtimeMirror(this.getClass.getClassLoader).mkToolBox()
    )
}

class ToolBoxEngine private(
                             private val historyStack: List[String],
                             private val toolbox: ToolBox[universe.type]
                           ) extends ScalaEngine {

  def runCode(snippet: String): (ScalaEngine, Try[Any]) = {
    val newHistory = snippet::historyStack
    val result = Try {
      val block: String = newHistory.reverse mkString ";"
      toolbox.eval(toolbox.parse(block))
    }
    (new ToolBoxEngine(newHistory, toolbox), result)
  }

}