/**
 * Created with IntelliJ IDEA.
 * User: S.H
 * Date: 12/05/11
 * Time: 10:44
 * To change this template use File | Settings | File Templates.
 */
import src.model.{MethodInfo, AttrInfo, ClassInfo}
import scala.io.Source

object app extends JavaClassParser {
  def main( args: Array[String] ){
    val file = Source.fromFile(args(0))
    val lines = file.getLines().mkString
    // パース
    val result = parseAll(cls, lines)
    //クラスインスタンス取得
    val clsObj = result.get
  }
}
