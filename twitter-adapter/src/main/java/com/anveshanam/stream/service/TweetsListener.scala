package com.anveshanam.stream.service

import org.apache.spark._
import org.apache.spark.storage._
import org.apache.spark.streaming.twitter.TwitterUtils

import scala.math.Ordering
import twitter4j.auth.OAuthAuthorization
import twitter4j.conf.ConfigurationBuilder
import org.apache.spark.streaming.StreamingContext
import org.apache.spark.streaming.Seconds
import org.apache.spark.streaming.Duration
import twitter4j.Status
import org.apache.spark.streaming.api.java.JavaDStream

object TweetsListener {

  final val CONSUMER_API_KEY = "vnx1eAUpwSclRDdr9Cu34V2J1";
  final val CONSUMER_API_SECRET = "z2nvFRfnTAK2mr5MVBkFHHwelrw7569bClFgX2y0cooTf2LJ1F"
  final val ACCESS_TOKEN = "105483192-n6fZ0epXziu2dMAAn9Wt8068VnUhfwx3EPOSKLmT"
  final val ACCESS_TOKEN_SECRET = "QFhTlIwlPwlzSPII3xfkJVjzxIO3yAr1IXAA6qvWVTj07"

  System.setProperty("twitter4j.oauth.consumerKey", "CONSUMER_API_KEY")
  System.setProperty("twitter4j.oauth.consumerSecret", "CONSUMER_API_SECRET")
  System.setProperty("twitter4j.oauth.accessToken", "ACCESS_TOKEN")
  System.setProperty("twitter4j.oauth.accessTokenSecret", "ACCESS_TOKEN_SECRET")

  // Directory to output top hashtags
  val outputDirectory = "D://twitter"

  // Recompute the top hashtags every 1 second
  val slideInterval = new Duration(2 * 1000)

  // Compute the top hashtags for the last 5 seconds
  val windowLength = new Duration(6 * 1000)

  // Wait this many seconds before stopping the streaming job
  val timeoutJobLength = 1200 * 1000

  var newContextCreated = false
  var num = 0

  // This is a helper class used for 

  def main(args: Array[String]): Unit = {
    // Create a Spark Streaming Context.
    val conf = new SparkConf().setMaster("local[2]").setAppName("TwitterStreaming")
    val ssc = new StreamingContext(conf, Seconds(2))

    //  val ssc = new StreamingContext(sc, slideInterval)
    // Create a Twitter Stream for the input source. 
    val auth = Some(new OAuthAuthorization(new ConfigurationBuilder().build()))
    val twitterStream = TwitterUtils.createStream(ssc, auth)

    // Parse the tweets and gather the hashTags.
    val hashTagStream = twitterStream.map(_.getText).flatMap(_.split(" ")).filter(_.startsWith("#"))

    // Compute the counts of each hashtag by window.
    val windowedhashTagCountStream = hashTagStream.map((_, 1)).reduceByKeyAndWindow((x: Int, y: Int) => x + y, windowLength, slideInterval)

    // For each window, calculate the top hashtags for that time period.
    windowedhashTagCountStream.foreachRDD(hashTagCountRDD => {
      val topEndpoints = hashTagCountRDD.top(10)(SecondValueOrdering)
      //dbutils.fs.put(s"${outputDirectory}/top_hashtags_${num}", topEndpoints.mkString("\n"), true)
      println(s"------ TOP HASHTAGS For window ${num}")
      println(topEndpoints.mkString("\n"))
      num = num + 1
    })


    
       
    newContextCreated = true
    ssc.start();
    ssc.awaitTermination();

  }
}