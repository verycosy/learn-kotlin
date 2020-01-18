fun main() {
    val test1 = "Test.Kotlin.String"
    
    println(test1.length)
    
    println(test1.toLowerCase())
    println(test1.toUpperCase())
    
    val test2 = test1.split(".")
    println(test2)
    
    println(test2.joinToString())
    println(test2.joinToString("-"))
    
    println(test1.substring(5..10))
    
    //
    
    val nullString: String? = null
    val emptyString = ""
    val blankString = " "
    val normalString = "A"
    
    println(nullString.isNullOrEmpty()) // true
    println(emptyString.isNullOrEmpty()) // true
    println(blankString.isNullOrEmpty()) // false
    println(normalString.isNullOrEmpty()) // false
    
    println()
    
    println(nullString.isNullOrBlank()) // true
    println(emptyString.isNullOrBlank()) // true
    println(blankString.isNullOrBlank()) // true (스페이스, 탭, 캐리지 리턴, 라인 피드 등)
    println(normalString.isNullOrBlank()) // false
    
    /*
     * null 상태로 속성이나 함수를 사용하기 위해선 null을 체크해줘야 컴파일이 된다
     * ?. null safe 연산자 - 객체가 null인지 확인 후 실행
     * ?: elvis 연산자 - 객체가 null이 아니면 그대로 사용, null이면 우측값 사용
     * !!. non-null assertion 연산자 - 컴파일시 null 여부를 체크 하지 않고, 런타임에서 null pointer exception이 발생하도록 방치
	*/
    
    var a: String? = null
    println(a?.toUpperCase())
    println(a?:"default".toUpperCase())
    println(a!!.toUpperCase())
    
    /* if문으로 체크할 수도 있지만
     * a?.run {
     * 	println(toUpperCase())
     * }
    */
}