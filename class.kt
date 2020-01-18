// package com.verycosy.kotlin
// 없으면 default 패키지.

// import com.verycosy.webrtc

// 자바와 달리 클래스명과 파일명이 달라도 됨
// 하나의 파일에 여러 개의 클래스를 넣어도 됨
// 파일이나 폴더로 구분 X, package로 구분하기 때문.

// 기본 자료형도 코틀린 내에서는 클래스로 이뤄져 있다.

fun main() {
    var a = Person("박보영", 1990)
	println("${a.name}")
    a.sayBirthYear()
    
    var b = Person("Cosy")
    b.sayBirthYear()
    
    var c = Dog("Very", 5)
    c.bark()

    Outer.Nested().introduce() // 실제로 이렇게 사용할 일은 없겠지만 .. 확인용
    
    val outer = Outer()
    val inner = outer.Inner()
    
    inner.introduceInner()
    inner.introduceOuter()
    
    outer.text = "Changed Outer Class"
    inner.introduceOuter()
}

class Person(var name:String, val birthYear:Int) {
    init { // 생성자
        println("${this.name} 인스턴스 생성됨")
    }
    
    constructor(name:String) : this(name, 1996) {
        println("보조 생성자 사용됨")
    }
    
    fun sayBirthYear() {
        println(birthYear)
    }
}

// 코틀린은 상속금지가 기본값이라 open 해줘야 한다
open class Animal(var name:String, var age:Int, var type:String)
{
    fun introduce() {
		// 출력	
    }
}

class Dog(name:String, age:Int) : Animal(name, age, "Dog")
{
    fun bark() {
        // 멍멍
    }
}

open class Student {
    open fun study() {
        // 공부
    }
}

class CollegeStudent : Student() {
    override fun study() { // 오버라이딩
        // 대학생은 공부 안 한다
    }
}

abstract class Game {
    abstract fun install()
    fun uninstall() {
        // 지운다
    } 
}

class LoL : Game() {
    override fun install() {
        // 설치한다
    }
}

/*
 * 추상 클래스는 생성자 O, 인터페이스는 X
 * 인터페이스에서 구현부가 있는 함수는 open 으로 간주, 없으면 abstract로 간주.
*/

interface Runner {
    fun run()
}

interface Eater {
    fun eat() {
        // 먹는다
    }
}

class Tester: Runner, Eater {
    override fun run() {
        // 달린다
    }
    
    override fun eat() {
        // 열심히 먹는다
    }
}

// 중첩 클래스와 달리 Inner 클래스는 혼자서 객체를 만들 수 없고
// 외부 클래스의 객체가 있어야만 생성/사용이 가능하다
// 중첩 클래스는 형태만 내부에 존재할 뿐, 실질적으로는 외부 클래스의 내용을 공유할 수 없다.
// 반면 이너 클래스는 실질적으로도 외부 클래스 안에 있기 때문에 사용 가능.

class Outer {
    var text = "Outer Class"
    
    class Nested {
        fun introduce() {
            println("Nested Class")
        }
    }
    
    inner class Inner {
        var text = "Inner Class"
        
        fun introduceInner() {
            println(text)
        }
        
        fun introduceOuter() {
            println(this@Outer.text)
        }
    }
}