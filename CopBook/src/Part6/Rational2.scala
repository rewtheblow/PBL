//クラス本体が無い場合は中かっこはいらない。
class Rational2(n:Int, d:Int){
  override def toString = n +"/"+ d		//デフォルトのtoStringメソッドの再定義
}