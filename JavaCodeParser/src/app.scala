/**
 * Created with IntelliJ IDEA.
 * User: heya
 * Date: 12/05/19
 * Time: 1:22
 * To change this template use File | Settings | File Templates.
 */

import parser.JavaCodeParser
import scala.io.Source

object app extends JavaCodeParser{
  def main(args: Array[String]) {
    val reader = Source.fromFile("class1.java")
    val res = parseAll(Java, reader.getLines().mkString)
    res
  }
}
