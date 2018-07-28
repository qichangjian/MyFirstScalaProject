object echoargs2 {
  def main(args: Array[String]): Unit = {
    //foreach
    /*
    args上调用foreach方法，并把它传入函数
    此例中，你传入了带有一个叫做arg参数的函数文本：function literal。函数体是println(arg)
    */
    args.foreach(arg => println(arg))

    //scala解释器推断arg的类型是String，因为String是你调用foreach的那个数组的元素类型。如果你喜欢更显式的，你可以加上类型名
    args.foreach((arg:String) => println(arg))

    //如果函数文本由带一个参数的一句话组成，你都不需要显式命名和指定参数
    //args.foreach(println)
    /**
      * 函数文本的语法：
      函数文本的语法就是，括号里的命名参数列表，右箭头，然后是函数体。
      （x: Int , y:Int）     =>       x + y
      括号里的命名列表参数   右箭头    函数体
      */


    //for枚举
    for(arg <- args)
      println(arg)

    /**
    <-右侧的是熟悉的args数组。<-左侧的是“arg”.
    val的名称（不是var）。（因为总归是val，你只要写arg就可，不要写成val arg。）
    尽管arg可能感觉像var，因为他在每次枚举都会得到新的值，但它的确是val : arg不能在for表达式的函数体中重新赋值。
    取而代之，对每个args数组的元素，一个新的arg val
      */
  }
}
