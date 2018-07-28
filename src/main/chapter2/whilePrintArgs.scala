object whilePrintArgs {
  def main(args:Array[String]): Unit = {
    var i = 0
    while(i<args.length){
      println(args(i))
      i += 1
    }

    for(arg <- args){
      println(arg)
    }

    args.foreach(arg => println(arg))

    println("-----------------进一步改进----------------------------")
    /*
    重构后的printArgs方法并不是纯函数式的，因为它有副作用——
    本例中，其副作用是打印到标准输出流。函数有副作用的马脚就是结果类型为Unit。
    如果某个函数不返回任何有用的值，就是说其结果类型为Unit，
    那么那个函数唯一能让世界有点儿变化的办法就是通过某种副作用
     */
    def printArgs(args: Array[String]): Unit = {
      args.foreach(arg => println(arg))
    }
    printArgs(args)

    /*
    更函数式的方式应该是定义对需打印的arg进行格式化的方法，但是仅返回格式化之后的字串
     */
    println()
    def formatArgs(args: Array[String]) = args.mkString("\n")
    print(formatArgs(args))
  }
}
