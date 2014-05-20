package com.indix.bootcamp

import edu.uci.ics.crawler4j.crawler.{CrawlConfig, CrawlController}
import edu.uci.ics.crawler4j.robotstxt.{RobotstxtConfig, RobotstxtServer}
import edu.uci.ics.crawler4j.fetcher.PageFetcher
import com.indix.bootcamp.crawler.{JabongCrawler, FlipkartCrawler}
import java.io.File
/*
object CrawlDriver extends App {
  val crawlStorageFolder = "/tmp/crawler4j-scala/data"
  new File(crawlStorageFolder).mkdirs()

  val numberOfCrawlers = 1

  val config = new CrawlConfig()
  config.setCrawlStorageFolder(crawlStorageFolder)
  config.setPolitenessDelay(900)
  config.setMaxDepthOfCrawling(5)
  config.setMaxPagesToFetch(500)
  //config.setResumableCrawling(true) // Enable as required
  config.setProxyHost( "proxy.production.indix.tv")
  config.setProxyPort(8080)
  // TODO: Add proxy support for your crawler to not get blocked.
  /*
    How Proxy works
      - http://en.wikipedia.org/wiki/Proxy_server
      - http://computer.howstuffworks.com/firewall4.htm

    Crawler4J Source Code - http://code.google.com/p/crawler4j/source/browse/
   */

  /*
   * Instantiate the controller for this crawl.
   */
  val pageFetcher = new PageFetcher(config)
  val robotstxtConfig = new RobotstxtConfig()
  val robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher)
  val controller = new CrawlController(config, pageFetcher, robotstxtServer)

  /*
   * For each crawl, you need to add some seed urls. These are the first
   * URLs that are fetched and then the crawler starts following links
   * which are found in these pages
   */
  controller.addSeed("http://www.flipkart.com")

  /*
   * Start the crawl. This is a blocking operation, meaning that your code
   * will reach the line after -this only when crawling is finished.
   */
  controller.start(classOf[FlipkartCrawler], numberOfCrawlers)

}
*/

object CrawlDriver extends App {
  val crawlStorageFolder = "/tmp/crawler4j-jabong/data"
  new File(crawlStorageFolder).mkdirs()

  val numberOfCrawlers = 1

  val config = new CrawlConfig()
  config.setCrawlStorageFolder(crawlStorageFolder)
  config.setPolitenessDelay(1000)
  config.setMaxDepthOfCrawling(4)
  config.setMaxPagesToFetch(2000)
  //config.setResumableCrawling(true) // Enable as required
 // config.setProxyHost( "proxy.production.indix.tv")
  //config.setProxyPort(8080)
  // TODO: Add proxy support for your crawler to not get blocked.
  /*
    How Proxy works
      - http://en.wikipedia.org/wiki/Proxy_server
      - http://computer.howstuffworks.com/firewall4.htm

    Crawler4J Source Code - http://code.google.com/p/crawler4j/source/browse/
   */

  /*
   * Instantiate the controller for this crawl.
   */
  val pageFetcher = new PageFetcher(config)
  val robotstxtConfig = new RobotstxtConfig()
  val robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher)
  val controller = new CrawlController(config, pageFetcher, robotstxtServer)

  /*
   * For each crawl, you need to add some seed urls. These are the first
   * URLs that are fetched and then the crawler starts following links
   * which are found in these pages
   */
  controller.addSeed("http://www.jabong.com/all-products/?usage=Running&source=sports-leftnav")

  /*
   * Start the crawl. This is a blocking operation, meaning that your code
   * will reach the line after -this only when crawling is finished.
   */
  controller.start(classOf[JabongCrawler], numberOfCrawlers)

}
