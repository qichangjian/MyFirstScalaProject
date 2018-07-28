object helloarg {
  def main(args: Array[String]): Unit = {
    //带参数
    /**
      * 通过Scala的名为args的数组可以获得传递给Scala脚本的命令行参数。
      * Scala里，数组以零开始，通过在括号里指定索引访问一个元素。
      * 所以Scala里数组steps的第一个元素是steps(0)，
      * 不是像Java里的steps[0]
      */
    println("Hello," + args(0) + "!")

    //5
    /**
      * 虽然本节的例子有助于解释while循环，但它们并未演示最好的Scala风格。
      * 在下一段中，你会看到避免用索引枚举数组的更好的手段。
      */
    var i = 0
    while(i < args.length){
      println(args(i))
      i += 1
    }
    println(i)
  }
}
