package src.model

/**
 * Created with IntelliJ IDEA.
 * User: S.H
 * Date: 12/05/12
 * Time: 2:14
 * To change this template use File | Settings | File Templates.
 */

class MethodInfo(access:String, retval:String, name:String) {
  override def toString = access + " " + retval + " " + name + "()"
}
