package part34
import scala.swing._
import scala.swing.event._

object SecondSwingApp extends SimpleGUIApplication {
	  // Frame
      def top = new MainFrame{
	    title = "Second Swing App"
	  
	  //Parts
	  val button = new Button{
	    text = "Click me"
	  }
	  val label = new Label{
	    text = "No Button clicks registerd"
	  }
	  
	  //パネル型のコンテンツ上に複数のコンポーネントを配置するようにする。
	  contents = new BoxPanel(Orientation.Vertical){
	    contents += button
	    contents += label
	    border = Swing.EmptyBorder(30,30,10,30)
	  }
	  //イベント登録（deaftoでイベント解除が可能）
	  listenTo(button)
	  var nClicks = 0
	  reactions +={
	    /*引数に押下されたボタンをもつ
	     * (ということはcase内でどのボタンが押下されたのかで処理分けか？)
	     */
	    case ButtonClicked(b) =>
	      nClicks += 1
	      label.text = "Number of button clicks: " + nClicks
	  }
	}
}