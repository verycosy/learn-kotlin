fun main() {
    var a = Drink()
    a.drink()
    
    var b: Drink = Cola()
    b.drink()
    
    if(b is Cola) { // 조건문 안에서만 잠시 다운캐스팅된다
        b.washDishes()
    }
    
    var c = b as Cola
    c.washDishes()
    b.washDishes() // as를 사용한 순간 b도 다운캐스팅된다
}

open class Drink {
    var name = "음료"
    
    open fun drink() {
        println("${name}를 마십니다")
    }
}

class Cola: Drink() {
    var type = "콜라"
    
    override fun drink() {
        println("${name} 중 ${type}를 마십니다")
    }
    
    fun washDishes() {
        println("${type}로 설거지를 합니다")
    }
}