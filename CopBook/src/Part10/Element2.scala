import Element.elem
abstract class Element {
	def contents: Array[String]
	
	def width: Int = 
	  if(height == 0) 0 else contents(0).length
	  
	def height: Int = contents.length
	
	def above(that:Element): Element = 
	  elem(this.contents ++ that.contents)
	  
	def beside(that: Element): Element = 
	  elem(
	      for(
	          (line1,line2) <- this.contents zip that.contents
	      )yield line1 + line2
	  )
	  
	def widen(w: Int): Element = 
	  if(w <= width) this
	  else{
	      val left = elem(' ', (w - width)/2, height)
	      var right = elem(' ', w - width - left.width, height)
	      left beside this beside right
	  }
	
	def heigthen(h: Int): Element = 
	  if(h <= height) this
	  else{
	      val top = elem(' ', width, (h - height)/2)
	      var bot = elem(' ', width, h - height - top.height)
	      top above this above bot
	  }
	  
	override def toString = contents mkString "\n"
}

object Element{
  
  private class ArrayElement(
      val contents: Array[String]
  )extends Element
  
  private class LineElement(s: String) extends Element{
	  val contents = Array(s)
	  override val width = s.length
	  override val height = 1
  }
  
  private class UniformElement(
	  ch: Char,
	  override val width: Int,
	  override val height: Int
  ) extends Element{
	  private val line = ch.toString * width
	  def contents = Array.fill(height)(line)
  }
  
  def elem (contents: Array[String]): Element =
    new ArrayElement(contents)
  def elem (chr:Char, width: Int, height: Int): Element = 
    new UniformElement(chr, width, height)
  def elem(line:String): Element = 
    new LineElement(line)
}