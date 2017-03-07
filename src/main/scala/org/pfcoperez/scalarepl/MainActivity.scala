package org.pfcoperez.scalarepl

import android.app.Activity
import android.os.Bundle
import android.util.Log
import org.pfcoperez.scalarepl.scalaengine.ScalaEngine
import org.pfcoperez.scalarepl.scalaengine.imp.ToolBoxEngine

object MainActivity {
    val TAG: String = "Main Activity";
}

class MainActivity extends Activity {

    import MainActivity._

    //private var currentEngineState: ScalaEngine = ToolBoxEngine()

    // allows accessing `.value` on TR.resource.constants
    implicit val context = this

    override def onCreate(savedInstanceState: Bundle): Unit = {
        super.onCreate(savedInstanceState)
        // type ascription is required due to SCL-10491
        val vh: TypedViewHolder.main = TypedViewHolder.setContentView(this, TR.layout.main)
        Log.w(TAG, "ok1")
        val currentEngineState: ScalaEngine = ToolBoxEngine()
        Log.w(TAG,"ok2")
        val result = currentEngineState.runCode("1+1")._2
        //val arr = Array(1,2,3)
        Log.w(TAG,"ok3")
        //val result = arr.mkString("-")
        vh.text.setText(s"Hello from scala: $result")
        /*vh.image.getDrawable match {
          case a: Animatable => a.start()
          case _ => // not animatable
        }*/
    }
}