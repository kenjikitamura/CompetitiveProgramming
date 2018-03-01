object Main extends App {
  var m = readInt
  var k = m match {
    case m if m < 100 => 0
    case m if 100 <= m && m <= 5000 => m / 1000
    case m if 6000 <= m && m <= 30000 => (m / 1000) + 50
    case m if 35000 <= m && m <= 70000 => ((m / 1000) - 30)/5 + 80
    case m if 70000 < m => 89
  }

  m = k.toString
  m = if (m.length == 1) "0" + m
  println(H1 - H2)
}
