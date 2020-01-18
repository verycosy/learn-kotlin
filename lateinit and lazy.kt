// lateinit은 기본 자료형(String 미포함)에는 사용 불가.
// 초기값 할당 전까지는 변수 사용 불가.

// 변수를 사용하는 시점까지 변수의 초기화를 늦춰주는 지연 대리자 속성(lazy delegate properties)
// 코드애서는 선언시 즉시 객체를 생성 및 할당하여 변수를 초기화하는 형태이지만, 사용 시점에 초기화되어 실행 시간 최적화 가능
// 람다함수로 초기화가 진행되므로 함수 안에 여러 개 구문이 들어갈 수 있고, 맨 마지막 값에 할당됨

fun main() {
    val a = LateInitSample()
    println(a.getLateInitText())
    
    a.text = "새로 할당한 값"
    println(a.getLateInitText())
    
    val number: Int by lazy {
        println("초기화")
        7
    }
    
    println("코드 시작")
    println(number)
    println(number)
}

class LateInitSample {
    lateinit var text: String
    
    fun getLateInitText(): String {
        if(::text.isInitialized) {
            return text
        } else {
            return "Default"
        }
    }
}