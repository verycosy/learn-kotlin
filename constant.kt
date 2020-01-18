// 상수는 기본 자료형(String 포함)에만 선언 가능.
// 런타임시 생성되는 일반적인 다른 클래스에는 사용 불가능
// 변수의 경우 런타임시 객체를 생성하는 데 시간이 더 소요 -> 성능하락
// 고정적으로 사용할 값은 상수를 통해 객체의 생성없이 메모리에 값을 고정 -> 성능향상

fun main() {
    val foodCourt = FoodCourt()
    
    foodCourt.searchPrice(FoodCourt.FOOD_STEAK)
}

class FoodCourt {
    companion object {
        const val FOOD_CREAM_PASTA ="크림파스타"
        const val FOOD_STEAK = "스테이크"
        const val FOOD_PIZZA = "피자"
    }
    
    fun searchPrice(foodName: String) {
        val price = when(foodName)
        {
            FOOD_CREAM_PASTA -> 13000
            FOOD_STEAK -> 25000
            FOOD_PIZZA -> 15000
            else -> 0
        }
        println("${foodName}의 가격은 ${price}원")
    }
}