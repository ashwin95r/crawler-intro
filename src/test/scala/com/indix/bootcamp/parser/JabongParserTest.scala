package com.indix.bootcamp.parser


import org.scalatest.{Matchers, FunSuite}
import com.indix.bootcamp.utils.TestUtils


/**
 * Created by ashwin on 20/5/14.
 */
class JabongParserTest extends FunSuite with Matchers with TestUtils{

   test("should parse product page") {
      val document = readDocument("/jabong/jabong_1.html")
      val parser = new JabongParser
      val parsedProduct = parser.parseProduct(document, "http://www.flipkart.com/microsoft-windows-8-8-1-sl-oem-64-bit/p/itmdztjtw8gymtwd?pid=OPSDNW94WXHFDGAF&srno=b_1&ref=4847fd47-daaa-4b4e-ab56-c3a3ac84c7d5")
      parsedProduct.name should be("Originals Lc9030 C1 Grey Aviator Sunglasses")
      parsedProduct.description should include("Step out in style wearing these grey coloured Aviators from the house of Lee Cooper. The stainless steel frame makes these Aviators durable and lightweight. The nylon lenses of these Aviators are super tough and temperature resistant. These Aviators will also help you keep harmful sun rays at bay.")
    }

    test("should parse prices from product page") {
      val document = readDocument("/jabong/jabong_1.html")
      val parser = new JabongParser
      val parsedPrice = parser.parsePrice(document)
      parsedPrice.listPrice should be(1899.0)
      parsedPrice.salePrice should be(1899.0)
    }


}