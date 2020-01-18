/* 
 * 여러 줄 주석
 * 꺄륵
 * 꺄르륵!
*/

fun main() {
    val nope = "안 변해" // 타입추론 & 불변
    var a:Int // Kotlin은 고전적 언어와 달리 초기화 필수. Null Pointer Exception 예방 등
    a = 123 // 사용하기 전에만 선언해주면 된다.
    
    var b:Long? = null // 꼭 필요한 경우엔 이렇게 사용 가능. nullable 변수
    
    // 코틀린은 내부적으로 문자열을 UTF-16BE로 관리
    var c:Long = a.toLong() // 명시적 형변환만 지원. 암시적은 X
    
    var intArr = arrayOf(1,2,3,4,5) // 배열은 내부적으로 Array 클래스가 제공
    var nullArr = arrayOfNulls<Int>(5)

    println('a')
    println("abcd")
    println("""a
    b
    c
    d""")
    println(add(3,5))
    
    println(a !is Int)
    
    doWhen("very")
    
    for(i in 0..9 step 3) { // Int Range
        print(i)
    }
    
    println()
    
    for(i in 9 downTo 0 step 2) {
        print(i)
    }
    
    println()
    
    
    for(i in 'a'..'d')
    	print(i)
        
     // while, do-while은 동일
     
     labelName@for(i in 1..10) {
         for(j in 1..10) {
             if(i==1 && j==2) break@labelName // continue도 동일
             println("i : $i, j : $j")
         }
     }
}

fun add(a:Int, b:Int):Int {
    return a+b
}

fun add2(a:Int, b:Int) = a+b // 단일 표현식 함수. 반환값은 타입추론 가능해서 타입 생략 가능.

fun doWhen(a:Any) {
    when(a) {
        1 -> println("정수 1")
        "Cosy" -> println("넘 편해버리구")
        is Long -> println("Long 타입")
        else -> println("읎다 읎어")
    }
    
    var result = when(a) {
        1 -> 1
        "Cosy" -> "편하다"
        else -> false
    }
    
    println(result)
}