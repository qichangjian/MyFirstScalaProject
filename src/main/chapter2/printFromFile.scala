import scala.io.Source

object printFromFile {
  def main(args: Array[String]): Unit = {

    def widthOfLength(s: String) = s.length.toString.length  //100 .length

    if (args.length > 0) {
      val lines = Source.fromFile(args(0)).getLines.toList          //get file's content array (notes1)
      val longestLine = lines.reduceLeft((a, b) => if (a.length > b.length) a else b)  //get longest line (notes2)
      val maxWidth = widthOfLength(longestLine)     //get longest line's number's number eg:100.length is 3
      for (line <- lines) {
        val numSpaces = maxWidth - widthOfLength(line) //every line front has how much space
        val padding = " " * numSpaces
        println(padding + line.length + " | " + line)//splicing output line
      }
    } else
      Console.err.println("Please enter filename")
  }
}
