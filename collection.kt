// Collection 클래스를 상속받는 List, Set, Map

fun main() {
    val a = listOf("사과", "딸기", "배")
    println(a[1])
    
    for(fruit in a)
    	println("${fruit}")
    println()
    
    val b = mutableListOf(6,3,1)
    println(b)
    
    b.add(4)
    println(b)
    
    b.add(2, 8)
    println(b)
    
    b.removeAt(1)
    println(b)
    
    b.shuffle()
    println(b)
    
    b.sort()
    println(b)

    val c = mutableSetOf("귤", "바나나", "키위")
    
    for(item in c)
    {
        println("${item}")
    }
    
    c.add("자몽")
    println(c)

	c.remove("바나나")
    println(c)
    
    println(c.contains("귤")) // 순서 X, 중복 X, 따라서 인덱스로 확인 불가
    
    val d = mutableMapOf("레드벨벳" to "음파음파", "트와이스" to "FANCY", "ITZY" to "ICY")
    
    for(entry in d)
    {
        println("${entry.key} : ${entry.value}")
    }
    
    d.put("오마이걸", "번지")
    println(d)
    
    d.remove("ITZY")
    
    println(d["레드벨벳"])

    // forEach, map, filter, any, all, none, find, count 등
    // list.forEach { print(it + " ") }
    // print(list.filter { it.startsWith("a") })
    // first나 last의 경우 조건에 맞는 객체가 없으면 NoSuchElementException
    // -> firstOrNull, lastOrNull

    // associateBy, groupBy, partition, flatMap, getOrElse, zip
}