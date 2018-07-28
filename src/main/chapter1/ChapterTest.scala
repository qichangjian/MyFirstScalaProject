object ChapterTest {
  def main(args: Array[String]): Unit = {
    //打印
    println("Hello Scalla!")

    //1.定义变量
    /**
      * Scala有两种变量，val和var
      * val类似于Java里的final变量。一旦初始化了，val就不能再赋值了
      * var如同Java里面的非final变量。var可以在它生命周期中被多次赋值
      */
    val msg = "Hello World msg!"          //类型推断
    val msg1: java.lang.String = "Test1"  //显示类型标注
    val msg2: String = "Test 2"           //显示类型标注
    println("val msg:" + msg + msg1 + msg2)

    var greeting = "Hello greeting!"
    greeting = "Change Hello greeting!"
    println("Var greeting:" + greeting)
    //2.定义函数
    /**
      *函数：
      * def 函数名（参数列表）：结果类型 = {}
      */
    def max(x:Int,y:Int):Int={
      if(x > y) x else y //Scala的if表达式可以像Java的三元操作符那样产生一个值
    }
    println("max1:" + max(1,2))
    /**
      * 如果函数是递归调用，必须显示的定义函数结果类型
      * 在max中可以不用写结果类型，编译器也能推断他
      * 如果函数仅由一个句子组成，你可以选不写大括号
      */
    def max2(x:Int,y:Int) = if(x>y) x else y
    println("max2:" + max2(2,3))
    /**
      * 既不带参数，也不带结果类型
      * Scala的Unit类型比较接近Java的void类型，
      * 而且实际上Java里每一个返回void的方法都被映射为Scala里返回Unit的方法
      */
    def greet() = println("Test def greet!")
    greet()

    //4.定义scala脚本
    /**
      *  文件夹下hello.scala和helloarg.scal是例子，在窗口中测试
      *  注意：这两个文件的文件夹必须 Mark d as 源文件
      */

    //5.用while循环，用for判断  (例子：cchoorgs)

    //6.用foreach和for枚举
    /*
     1.前边的编程风格都很指令式，一次性发出一个指令式的命令，用循环去枚举
     2.函数式语言的一个主要特征是，函数是第一类结构
     3.例子：echoargs2
     */



  }
}
