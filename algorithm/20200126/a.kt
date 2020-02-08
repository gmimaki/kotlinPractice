fun main(args: Array<String>) {
    val list: List<Int> = readLine()!!.split(" ").map { it.toInt() }
    var hp = list[0]
    val attackPower = list[1]
    var attackCount = 0;

    while (hp > 0) {
        hp = hp - attackPower
        attackCount++
    }
    println(attackCount)
}

