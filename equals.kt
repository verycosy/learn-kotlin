/*
 == : 내용의 동일성
 === : 객체의 동일성
 내용의 동일성은 자동으로 판단되는 것이 아닌, 코틀린의 모든 클래스가 내부적으로 상속받는 Any라는 최상위 클래스의 equals()가 반환하는 boolean 값으로 판단
 기본 자료형에는 equals가 이미 구현되어 있지만 커스텀 클래스는 직접 구현해줘야 한다.
*/

fun main() {
    var a = Product("콜라", 1000)
    var b = Product("콜라", 1000)
    var c = a
    var d = Product("사이다", 1000)
    
    println(a == b)
    println(a === b)
    
    println(a == c)
    println(a === c)
    
    println(a == d)
    println(a === d)
}

class Product(val name: String, val price: Int) {
    override fun equals(other: Any?): Boolean {
        if(other is Product) {
            return other.name == name && other.price == price
        } else {
            return false
        }
    }
}