// 고차함수

fun main() {
	b(::a) // 일반함수를 고차함수로 변형해주는 연산자 ::
    val c: (String)->Unit = { a -> println("$a 람다 함수") } // 람다는 고차함수
    val d = {str:String -> println("") }
    b(c)
    
    val calculate: (Int, Int) -> Int = { 
        a, b -> println(a)
        		println(b)
                a+b // 최종 반환값
    }
    
    var e: () -> Unit = { println("No parameter")} // 파라미터 없는 경우
    var f: (String) -> Unit = { println("$it")} // 파라미터가 1개면 it으로 받을 수 있다
    
    println(calculate(1,2))

    someFunction(name="verycosy")
    println(6 multiply 4) // 6이 this, 4가 x
    println(6.multiply(4))
}

fun a(str: String) {
    println("$str 함수 a")
}

// 문자열을 받고 반환형이 없는 함수 a를 이렇게 받는다.
fun b(functionName:(String)->Unit) {
    functionName("b가 호출한")
}

// overloading

fun read(x: Int) {}
fun read(x: String) {}

// default & named arguments
fun someFunction(count: Int=1, name:String="my name") {}

// 같은 자료형, 개수 상관 X - variable number of arguments, 당연히 파라미터 중 맨 끝에 위치해야 함
fun sum(vararg numbers: Int) {
    var sum = 0
    
    for(n in numbers) {
        sum += n
    }
    
    print(sum)
}

// 연산자처럼 쓸 수 있는 infix
// class 안에서 선언할 경우, 적용할 클래스가 자기 자신이므로 class 이름을 사용하지 않는다.
// infix fun multiply(x: Int): Int = this * x 
infix fun Int.multiply(x: Int): Int = this * x