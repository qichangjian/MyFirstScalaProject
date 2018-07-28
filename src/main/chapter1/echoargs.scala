object echoargs {
  def main(args: Array[String]): Unit = {
    var i = 0

    //用while循环；用if判断
    /*
    1.必须把while和if的布尔表达式放在括号中
    2.如果代码块只有一个句子，大括号是可选的
    3.scala中分号经常是可选的
     */
    while(i < args.length){
      if(i != 0){
        print(" ");
      }
      print(args(i));
      i += 1;
    }
    println("\n" + i)

    //删减后
    var j = 0
    while(j < args.length){
      if(j != 0)
        print(" ")
      print(args(j))
      j += 1
    }
    print("\n" + j)
  }
}
