package part34
import scala.swing._

object FirstSwingApp extends SimpleGUIApplication {
	def top = new MainFrame{
	  title = "First Swing App"
	  //MainFrameはコンテンツを一つしか持てない。
	  contents = new Button{
	    text = "Click me"
	  }
	}
}