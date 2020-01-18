fun main() {
    println(Counter.count)
    
    Counter.countUp()
    Counter.countUp()
    
    println(Counter.count)
    
    Counter.clear()
    println(Counter.count)
    
    var a = FoodPoll("짜장")
    var b = FoodPoll("짬뽕")
    
    a.vote()
    a.vote()
    
    b.vote()
    
    println(a.count)
    println(b.count)
    println(FoodPoll.total)
}

// 그 자체로 객체이기 때문에 생성자 X
// 언어 차원에서 싱글톤 패턴을 지원
// 공용으로 사용할 객체
object Counter {
    var count = 0
    
    fun countUp() {
        count++
    }
    
    fun clear() {
        count = 0
    }
}

class FoodPoll(val name:String) {
    companion object { // 인스턴스 내의 object. 다른 언어의 static과 유사하다.
        var total = 0
    }
    
    var count = 0
    
    fun vote() {
        total++
        count++
    }
}