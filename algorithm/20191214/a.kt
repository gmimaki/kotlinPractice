fun main(args: Array<String>) {
    val input = readLine()
    val int = when(input?.toIntOrNull()) {
        is Int -> input.toInt() * 2
        else -> "error"
    }
     
    println(int)
}

