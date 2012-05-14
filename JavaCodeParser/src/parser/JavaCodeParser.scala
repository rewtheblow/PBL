package parser

/**
 * Created with IntelliJ IDEA.
 * User: heya
 * Date: 12/05/15
 * Time: 0:16
 * To change this template use File | Settings | File Templates.
 */
import scala.util.parsing.combinator._

class JavaCodeParser extends JavaTokenParsers  {
 /*
  * Language Syntax
  *
  */
  def Java: Parser[Any] = MyPackage~rep(Import)~Class
  def MyPackage: Parser[Any] = "package"~PackageName~";"
  def PackageName: Parser[Any] = ident | PackageName~"."~ident
  def Import: Parser[Any] = SingleTypeImport | TypeImportOnDemand
  def SingleTypeImport: Parser[Any] = "import"~TypeName
  def TypeName: Parser[Any] = PackageName
  def TypeImportOnDemand: Parser[Any] = "import"~PackageName~".*"
  def Class: Parser[Any] = rep(ClassModifier)~"class"~ident~rep(MySuper)~rep(MyInterface)~ClassBody
  def ClassModifier: Parser[Any] = "public" | "abstract" | "final"
  def MySuper: Parser[Any] = "extends"~ClassType
  def ClassType: Parser[Any] = PackageName
  def MyInterface: Parser[Any] = "implements"~InterfaceTypeList
  def InterfaceTypeList: Parser[Any] = PackageName
  def ClassBody: Parser[Any] = "{"~rep(ClassBodyDeclaration)~"}"
  def ClassBodyDeclaration: Parser[Any] = ClassMemberDeclaration | StaticInitializer


}
