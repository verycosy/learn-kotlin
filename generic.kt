// 네이밍은 관례로 T, U, V .. 순

fun main() {
    UsingGeneric(A()).doShouting()
    UsingGeneric(B()).doShouting()
    UsingGeneric(C()).doShouting()
    
    doShouting(B())
}

open class A {
    open fun shout() {
        println("A: 끄앙")
    }
}

class B: A() {
    override fun shout() {
        println("B: 끄앙")
    }
}

class C: A() {
    override fun shout() {
        println("C: 끄앙")
    }
}

// <T: A>는 특정 super class를 상속받은 클래스들만.
// class UsingGeneric(val t:A) 로 해도 되지만 캐스팅 연산은 속도 저하를 일으키므로 제너릭을 사용하자.
class UsingGeneric<T: A>(val t: T) {
    fun doShouting() {
        t.shout()
    }
}

fun <T: A> doShouting(t: T) {
    t.shout()
}