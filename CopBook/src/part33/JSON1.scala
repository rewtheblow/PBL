package part33
import scala.util.parsing.combinator._

class JSON1 extends JavaTokenParsers {
  
  /*
   * def obj: Parser[Any]	 = "{"~repsep(member, ",")~"}"
   */
  def obj: Parser[Map[String, Any]] = 
    "{"~> repsep(member, ",") <~"}" ^^ (Map() ++ _)
  /*
   * def arr: Parser[Any]	 = "["~repsep(value, ",")~"]"
   */
  def arr: Parser[List[Any]]	 = 
    "["~> repsep(value, ",") <~"]"
  /*
   * def member: Parser[Any]= stringLiteral~":"~value
   */
  def member: Parser[ (String,Any) ] =
    stringLiteral~":"~value ^^
      { case name~":"~value => (name, value) }
  /* 
   *def value: Parser[Any] = obj | arr | 
   *                       stringLiteral | 
   *                        floatingPointNumber |
   *                        "null" | "true" | "false"
   */
   def value: Parser[Any] = {
    		  obj |
    		  arr | 
              stringLiteral | 
              floatingPointNumber ^^ (_.toDouble) |
              "null" ^^ ( x => null ) |
              "true" ^^ ( x => true ) | 
              "false" ^^ ( x => false )   
   }   
}