import scala.io.Source

object LongLines{
  def processFile(filename: String, width: Int){
    
    println("LongLine2\n")
    
    //ローカル関数。外の関数の引数も使える。
    def processLine( line: String ){
      if(line.length > width)
        println(filename + ": " + line.trim)
    }  
  
    val source = Source.fromFile(filename)
    for(line <- source.getLines())
      processLine(line)
  }
  

}