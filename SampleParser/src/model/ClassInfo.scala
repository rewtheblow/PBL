package src.model

/**
 * Created with IntelliJ IDEA.
 * User: S.H
 * Date: 12/05/12
 * Time: 10:15
 * To change this template use File | Settings | File Templates.
 */

class ClassInfo(var access:String, var name:String, var attr:List[AttrInfo], var method:List[MethodInfo]) {
  override def toString = {
    access + " " + name + "\n" + attr.mkString("\n") + "\n" + method.mkString("\n")
  }
}
