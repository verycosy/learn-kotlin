// Data 클래스는 데이터를 다루는 데에 최적화된 클래스.
// 5가지 기능을 내부적으로 자동으로 생성
// 1. equals()
// 2. hashCode()
// 3. toString()
// 4. copy() - 그대로 or 속성 일부 교체
// 5. componentX() - 속성 반환

fun main() {
    val a = General("보영", 212)
    println(a == General("보영", 212)) // false
    println(a.hashCode()) // 681842940
    println(a) // General@28a418fc
    
    val b = Data("루다", 306)
    println(b == Data("루다", 306)) // true
    println(b.hashCode()) // 46909878
    println(b) // Data(name=루다, id=306)
    
    println(b.copy()) // Data(name=루다, id=306)v
    println(b.copy("아린")) // Data(name=아린, id=306)
    println(b.copy(id=618)) // Data(name=루다, id=618) & named arguments
    
    val list = listOf(Data("보영", 212), Data("루다", 306), Data("아린", 618))
    
    for((a, b) in list)
    	println("${a}, ${b}")
        
    var state = State.SING
    println(state)
    
    state = State.SLEEP
    println(state.isSleeping())
    
    state = State.EAT
    println(state.message)
}

class General(val name:String, val id:Int)
data class Data(val name: String, val id: Int)

enum class State(val message:String) { // 이렇게 생성자를 넣어주면 속성도 선언가능
    SING("음음음~~"),
    EAT("냠냠"),
    SLEEP("쿨쿨"); // 함수는 맨 끝에 선언해주는데, 이때 여기서 세미콜론 붙여줘야 함
    
    fun isSleeping() = this == State.SLEEP
}