//クラス本体が無い場合は中かっこはいらない。
class Rational3(n:Int, d:Int){
  require(d != 0)	//分母に0が設定された時にはじく（IlligalArgumentExceptionが発生）
  override def toString = n +"/"+ d		//デフォルトのtoStringメソッドの再定義
}