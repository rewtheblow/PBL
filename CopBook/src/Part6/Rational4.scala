//クラス本体が無い場合は中かっこはいらない。
class Rational4(n: Int, d: Int){
  require(d != 0)	//分母に0が設定された時にはじく（IlligalArgumentExceptionが発生）
  
  val numer: Int = n
  val denom: Int = d
  
  override def toString = numer +"/"+ denom	//デフォルトのtoStringメソッドの再定義
  
  def add(that: Rational4): Rational4 = 
    new Rational4(
      numer * that.denom + that.numer * denom,
      denom * that.denom
      )
}