/*
Package、import文関連のテスト
以下要素のテスト
<MyPackage>,<Import>,<SingleTypeImport>,<TypeImportOnDemand>
・"java.lang.*"のうち"*"のパースが出来ない。
  →正規表現の"""[a-zA-Z_]\w*""".rでは"*"が含まれてないのでimportの要素を分解できなかった。
*/
package class1.pack;

import java.lang.*
import java.io.File

public class class1 {

}