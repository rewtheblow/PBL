
class Rational8(n: Int, d: Int){
  require(d != 0)
  
  private val g = gcd(n.abs, d.abs) 
  val numer = n / g 
  val denom = d / g 
  
  // +メソッドの実装
  def + ( that:Rational8 ): Rational8 = 
    new Rational8(
      numer * that.denom + that.numer * denom,
      denom * that.denom
      )
  def + ( i:Int ): Rational8 = 
    new Rational8(numer + i * denom, denom)
  
  // -メソッドの実装
  def - ( that:Rational8 ): Rational8 = 
    new Rational8(
      numer * that.denom - that.numer * denom,
      denom * that.denom
      )
  def - ( i:Int ): Rational8 = 
    new Rational8(numer - i * denom, denom)
  
  // *メソッドの実装
  def * ( that:Rational8 ): Rational8 = 
    new Rational8(numer * that.numer, denom * that.denom)
  def * ( i:Int ): Rational8 = 
    new Rational8(numer * i, denom )
  
  // /メソッドの実装
  def / ( that:Rational8 ): Rational8 = 
    new Rational8(numer * that.denom, denom * that.numer)
  def / ( i:Int ): Rational8 = 
    new Rational8(numer , denom * i )
    
  def this(n: Int) = this(n, 1)
  
  override def toString = numer +"/"+ denom
      
  private def gcd(a: Int, b: Int): Int = 
    if(b == 0) a else gcd(b, a%b)
}