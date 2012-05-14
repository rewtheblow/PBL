/**
 * Created with IntelliJ IDEA.
 * User: HEYA
 * Date: 12/05/11
 * Time: 10:44
 * To change this template use File | Settings | File Templates.
 */

import scala.util.parsing.combinator._
import src.model._

class JavaClassParser extends JavaTokenParsers {
/**
 * Language Syntax
 *	<cls>::= access "class" "{" {attr} {method} "}"
 *  <attr>::= access vartype name ";"
 *  <method>::= access retval name "()" "{}"
 *
 *  <access>::= ( "public" | "private" )
 *  <retval>::=  "void"
 *  <name>:: = [a-zA-z_]\w*
 *  <vartype>:: = [a-zA-z_]\w*
 */
  def cls:    Parser[ClassInfo] = access~"class"~name~"{"~rep(attr)~rep(method)~"}" ^^ {
    case access~"class"~name~"{"~attr~method~"}" => clsFunc(access, name, attr, method)
  }
  def attr:   Parser[AttrInfo] = access~vartype~name~";" ^^ {
    case access~vartype~name~";" => attrFunc(access, vartype, name)
  }
  def method: Parser[MethodInfo] = access~retval~name~"()"~"{}" ^^ {
    case access~retval~name~"()"~"{}" => methodFunc(access, retval, name)
  }

  def access: Parser[String] = ( "public" | "private" )
  def retval: Parser[String] = "void"
  def name: Parser[String] = ident
  def vartype: Parser[String] = ident

  //変換関数
  private def clsFunc(access:String, name:String, attr:List[AttrInfo], method:List[MethodInfo]):ClassInfo = {
    new ClassInfo(access, name, attr, method)
  }
  private def methodFunc(access:String, retval:String, name:String):MethodInfo = {
    new MethodInfo(access, retval, name)
  }
  private def attrFunc(access:String, vartype:String, name:String): AttrInfo = {
    new AttrInfo(access, vartype, name)
  }


}
