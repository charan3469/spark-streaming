package com.sundogsoftware.sparkstreaming

import org.apache.spark._
import org.apache.log4j._

object HelloWorld {
  def main(args: Array[String]): Unit = {

    Logger.getLogger("org").setLevel(Level.ERROR)

    val sc = new SparkContext("local[*]", "HelloWorld")

    val lines = sc.textFile("data/ml-100k/test")
      val tempRDD = lines.map(x=>(x.split(" ")(0),x.split(" ")(1).toInt)).aggregateByKey()
    tempRDD.foreach(println)

    //println("Hello world! The u.data file has " + numLines + " lines.")

    sc.stop()
  }
}
