
class Rational5(n: Int, d: Int){
  require(d != 0)	
  
  val numer: Int = n
  val denom: Int = d
  
  def this(n: Int) = this(n, 1) //補助コンストラクタ
  
  override def toString = numer +"/"+ denom
  
  def add(that: Rational5): Rational5 = 
    new Rational5(
      numer * that.denom + that.numer * denom,
      denom * that.denom
      )
}