import java.math.BigInteger

import scala.collection.mutable

object ChapterTest2 {
  def main(args: Array[String]): Unit = {
    //7.带类型的参数化数组     可变
    val big = new BigInteger("1235")

    //定义字符串数组并初始化，打印
    val greetStrings = new Array[String](3)
    greetStrings(0) = "Hello"
    greetStrings(1) = ","
    greetStrings(2) = "World!\n"
    for(i <- 0 to 2)
      println(greetStrings(i))
    /**
      1.当你用val定义一个变量，那么这个变量就不能重新赋值，但它指向的对象却仍可以暗自改变。
      所以在本例中，你不能把greetStrings重新赋值成不同的数组；greetStrings将永远指向那个它被初始化时候指向的同一个Array[String]实例。
     但是你能一遍遍修改那个Array[String]的元素，因此数组本身是可变的。

      2.当第一步里你在Scala解释器里输入1 + 2，你
     实际上正在Int对象1上调用一个名为+的方法，并把2当作参数传给它。

      3.。当你在一个或多个值或变量外使用括号时，Scala会把它转换成对名为apply的方法调用。
      于是greetStrings(i)转换成greetStrings.apply(i)。
      所以Scala里访问数组的元素也只不过是跟其它的一样的方法调用。
      这个原则不仅仅局限于数组：任何对某些在括号中的参数的对象的应用将都被转换为对apply方法的调用。
      当然前提是这个类型实际定义过apply方法。所以这不是一个特例，而是一个通则。
      4.与之相似的是，当对带有括号并包括一到若干参数的变量赋值时，
      编译器将把它转化为对带有括号里参数和等号右边的对象的update方法的调用
      */
    greetStrings.update(0,"Hellos")
    greetStrings.update(1,".")
    greetStrings.update(2,"words")
    for(i <- 0 to 2)
      print(greetStrings.apply(i))

    //简单写法
    val userNames = Array("qichangjian","tangqi","dingshifa")
    userNames(0) = "changeqi"
    for(username <- userNames)
      println(username)

    //8.使用List      不可变
    //创建一个简单的list
    val onetwothree = List(1,2,3) //list中的值是不可变的
    for(i <- 0 to 2)
      print(onetwothree(i))

    //List有个叫“:::”的方法实现叠加功能
    val onetwo = List(1,2)
    val threefour = List(3,4)
    val onetwothreefour = onetwo ::: threefour
    val testone = onetwo :: threefour
    println(onetwo + " and " + threefour + " were not mutated.")
    println("Thus, " + onetwothreefour + " is a new list")
    println("Test: " + testone)

    val twothree = List(2,3)
    val oneTwoThree = 1 :: twothree //右操作符 == twothree。：：（1）
    //val twothreeone = twothree :: 1 //这个错误
    println("onetwothree:" + oneTwoThree)

    /**
    由于定义空类的捷径是Nil，
    所以一种初始化新List的方法是把所有元素用cons操作符串起来，Nil作为最后一个元素
      */
    val one_two_three = 1 :: 2 :: 3 :: Nil
    println(one_two_three)

    /**
    为什么列表不支持append？
    类List没有提供append操作，因为随着列表变长append的耗时将呈线性增长，
    而使用::做前缀则仅花费常量时间。如果你想通过添加元素来构造列表，
    你的选择是把它们前缀进去，当你完成之后再调用reverse；
    或使用ListBuffer，一种提供append操作的可变列表，当你完成之后调用toList。
    ListBuffer将在22.2节中描述。
      */
    //Page:50的常见方法和使用


    //9.使用Tuple元组   与列表一样，元组也是不可变的，但与列表不同，元组可以包含不同类型的元素
    /**实例化一个装有一些对象的新元组，只要把这些对象放在括号里，并用逗号分隔即可。
      * 一旦你已经实例化了一个元组，你可以用点号，下划线和一个基于1的元素索引访问它

    注意：从1开始
    因为对于拥有静态类型元组的其他语言，如Haskell和ML，从1开始是传统的设定
      */
    val pair = (99,"Luftballons")
    println(pair._1)//注意：从1开始
    println(pair._2)

    //10.使用Set集和Map映射
    /**
      * 要向集加入新的变量，可以在集上调用+，传入新的元素。
      * 可变的和不可变的集都提供了+方法，但它们的行为不同。
      * 可变集将把元素加入自身，不可变集将创建并返回一个包含了添加元素的新集
      */
    //不可变集
    /*
    你使用的是不可变集，因此+调用将产生一个全新集。
    因此尽管可变集提供的实际上是+=方法，不可变集却不是。
    本例中，代码的第二行，“jetSet += "Lear"”，
    实质上是下面写法的简写： jetSet = jetSet + "Lear"
     */
    var jetSet = Set("Boeing","Airbus")
    jetSet += "Lear"
    println(jetSet.contains("Cessna"))

    //可变集
    /*
    如果你需要不可变集，就需要使用一个引用：import，
    import scala.collection.mutable.Set

     +=是实际定义在可变集上的方法。
     如果你想的话，你可以替换掉movieSet += "Shrek"的写法，
     写成movieSet.+=("Shrek")
     */
    val movieSet = scala.collection.mutable.Set("Hitch","Poltergeist")
    movieSet += "Shrek"
    println(movieSet)

    //显式的集类
    val hashSet = mutable.HashSet("Tomatoes","Chilies")
    println(hashSet + " Coriander")

    //Map集合类映射
    /*
    Map是Scala里另一种有用的集合类。
    和集一样，Scala采用了类继承机制提供了可变的和不可变的两种版本的Map，
     */
    //可变映射 不是缺省的
    val treasureMap = mutable.Map[Int,String]()
    treasureMap += (1 -> "Go to island.")
    treasureMap += (2 -> "Find big x on ground.")
    treasureMap += (3 -> "Dog.")
    println(treasureMap(2))

    //不可变映射  缺省的
    //不可变映射，就不用引用任何类了，因为不可变映射是缺省的
    val romanNumeral = Map(
      1 -> "I",2->"II",3->"III",4->"IV",5->"V"
    )
    println(romanNumeral(4))

    //11.识别函数式风格
    //练习代码在：whilePrintArgs.scala
    /*
    如果代码包含了任何var变量，那它大概就是指令式的风格。
    如果代码根本就没有var——就是说仅仅包含val——那它大概是函数式的风格。
    因此向函数式风格推进的一个方式，就是尝试不用任何var编程。
     */

    /*
    Scala程序员的平衡感 崇尚val，不可变对象和没有副作用的方法。
    首先想到它们。只有在特定需要和判断之后才选择var，可变对象和有副作用的方法。
     */

    //12.从文件中读取信息行
    //重要问题：输出文件有编码问题？
    /*注释1：notes1
    最后的toList是必须加的，因为getLines方法返回的是枚举器。
    一旦你使用它完成遍历，枚举器就失效了。
    而通过调用toList把它转换为List，你就可以枚举任意次数，
    代价就是把文件中的所有行一次性贮存在内存里。
    lines变量因此就指向着包含了命令行指定的文件文本字串的数组。
     */
    /* 注释2：notes2
    reduceLeft方法把传入的方法应用于lines的前两个元素，
    然后再应用于第一次应用的结果和lines接下去的一个元素，等等，直至整个列表。
    每次这样的应用，结果将是碰到的最长一行，
    因为传入的函数，(a, b) => if (a.length > b.length) a else b，返回两个传入字串的最长那个。
    reduceLeft将传回最后一次应用的结果，也就是本例lines中包含的最长字串。
     */

    /*
    def widthOfLength(s: String) = s.length.toString.length  //100.length

    if (args.length > 0) {
      val lines = Source.fromFile(args(0)).getLines.toList //get file's content array (notes1)
      val longestLine = lines.reduceLeft((a, b) => if (a.length > b.length) a else b) //get longest line (notes2)
      val maxWidth = widthOfLength(longestLine) //get longest line's number's number  eg：100.length is 3
      for (line <- lines) {
        val numSpaces = maxWidth - widthOfLength(line) //every line front has how much space
        val padding = " " * numSpaces
        println(padding + line.length + " | " + line)  //splicing output line
      }
    } else
      Console.err.println("Please enter filename")
  }
     */
  }
}
