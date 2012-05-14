
class Rational6(n: Int, d: Int){
  require(d != 0)
  
  private val g = gcd(n.abs, d.abs) //abs:絶対値取得,nとdの最大公約数をgに代入 
  val numer = n / g  //分子の正規化
  val denom = d / g  //分母の正規化
  
  def this(n: Int) = this(n, 1)
  
  override def toString = numer +"/"+ denom
  
  def add(that: Rational6): Rational6 = 
    new Rational6(
      numer * that.denom + that.numer * denom,
      denom * that.denom
      )
      
  private def gcd(a: Int, b: Int): Int = 
    if(b == 0) a else gcd(b, a%b)
}