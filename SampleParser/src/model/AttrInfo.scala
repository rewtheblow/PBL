package src.model

/**
 * Created with IntelliJ IDEA.
 * User: heya
 * Date: 12/05/12
 * Time: 3:16
 * To change this template use File | Settings | File Templates.
 */

class AttrInfo(access:String, vartype:String, name: String) {
  override def toString = access + " " + vartype + " " + name + ";"
}
