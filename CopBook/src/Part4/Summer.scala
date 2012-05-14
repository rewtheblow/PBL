import ChecksumAccumulator.calculate
//  スタンドアロンオブジェクト
//（どのクラスとも結びついてないシングルトンオブジェクトのこと）
object Summer{
  def main(args:Array[String]){
    for(arg<-args)
      println(arg + ": " + calculate(arg))
  }
}