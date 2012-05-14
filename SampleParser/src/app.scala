/**
 * Created with IntelliJ IDEA.
 * User: HEYA
 * Date: 12/05/11
 * Time: 10:44
 * To change this template use File | Settings | File Templates.
 */
import java.io.FileReader
import src.model.{MethodInfo, AttrInfo, ClassInfo}

object app extends JavaClassParser {
  def main( args: Array[String] ){
    val reader: FileReader = new FileReader(args(0))
    // パース
    val result: ParseResult[ClassInfo] = parseAll(cls, reader)
    //クラスインスタンス取得
    val clsObj = result.get
  }
}
