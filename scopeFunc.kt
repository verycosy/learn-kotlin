// 스코프함수는 인스턴스의 속성이나 함수를 좀 더 깔끔하게 불러 쓸 수 있다

fun main() {
    var price = 5000
    
    var a = Book("코틀린", 10000).apply {
        name = "[기초]" + name
        discount()
    }
    
    a.run { // run이 인스턴스의 price보다 main의 price를 우선시하여 8000이 아닌 5000이 출력된다.
        println("상품명 : ${name}, 가격 : ${price}원")
    } // with(a) { ... } 랑 같다. 그냥 파라미터로 인스턴스를 받는 것뿐.
    
    a.let {
        println("상품명 : ${it.name}, 가격 : ${it.price}원")
    }
    
    var b = a.run {
        println(a.price)
        a.name
    }
    
    // apply, also : 처리가 끝나면 인스턴스를 반환
    // run, let : 처리가 끝나면 최종값 반환
    
    println(b)
}

class Book(var name:String, var price:Int)
{
    fun discount()
    {
        price -= 2000
    }
}