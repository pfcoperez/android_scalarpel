package org.pfcoperez.scalarepl

import android.app.Activity
import android.os.Bundle

import org.pfcoperez.scalarepl.scalaengine.ScalaEngine
import org.pfcoperez.scalarepl.scalaengine.imp.ToolBoxEngine

class MainActivity extends Activity {

    private var currentEngineState: ScalaEngine = ToolBoxEngine()

    // allows accessing `.value` on TR.resource.constants
    implicit val context = this

    override def onCreate(savedInstanceState: Bundle): Unit = {
        super.onCreate(savedInstanceState)
        // type ascription is required due to SCL-10491
        val vh: TypedViewHolder.main = TypedViewHolder.setContentView(this, TR.layout.main)
        val result = currentEngineState.runCode("1+1")._2
        vh.text.setText(s"Hello from scala: $result")
        /*vh.image.getDrawable match {
          case a: Animatable => a.start()
          case _ => // not animatable
        }*/
    }
}