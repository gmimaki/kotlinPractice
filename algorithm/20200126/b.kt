fun main(args: Array<String>) {
    val arr: Array<String> = Array(2) {
        readLine()!!
    }
    val line1 = arr[0]!!.split(" ")
    val line2 = arr[1]!!.split(" ")
    

    val monsterLife: Int = line1[0]!!.toInt()
    val wazaNum = line1[1]
    
    var total: Int = 0
    for (item in line2) {
        total = total + item!!.toInt()
    }
    
    print(when {
        monsterLife > total -> "No"
        else -> "Yes"
    })
}
