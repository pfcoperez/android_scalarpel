scalaVersion := "2.11.8"

enablePlugins(AndroidApp)
android.useSupportVectors

versionCode := Some(1)
version := "0.1-SNAPSHOT"

instrumentTestRunner :=
  "android.support.test.runner.AndroidJUnitRunner"

platformTarget := "android-25"

javacOptions in Compile ++= "-source" :: "1.7" :: "-target" :: "1.7" :: Nil

libraryDependencies ++=
  "com.android.support" % "appcompat-v7" % "24.0.0" ::
  "com.android.support.test" % "runner" % "0.5" % "androidTest" ::
  "com.android.support.test.espresso" % "espresso-core" % "2.2.2" % "androidTest" ::
  "org.scala-lang" % "scala-compiler" % "2.11.8" ::
  "org.scala-lang" % "scala-reflect" % "2.11.8" ::
  "org.scala-lang.modules" %% "scala-xml" % "1.0.6" ::
  Nil

proguardOptions ++=
  //"-dontobfuscate" ::
  "-keepattributes InnerClasses" ::
  "-keep interface java.rmi.** { *; }" ::
  "-keep class org.pfcoperez.scalarepl.** { *; }" ::
  "-keep class scala.reflect.** { *; }" ::
  "-keep class scala.** { *; }" ::
  //"-keep class scala.**" ::
  Nil

dexAdditionalParams += "--core-library"

dexMaxHeap in Android :="4096M"
dexMulti in Android := true
