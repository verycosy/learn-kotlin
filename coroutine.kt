// coroutine은 메인루틴과 별도로 실행됨
// 
// 제어범위 및 실행범위를 지정할 수 있는데, 이를 Scope라고 함
// GlobalScope: 프로그램 어디서나 제어, 동작이 가능한 기본 범위
// CoroutineScope: 특정한 목적의 Dispatcher를 지정하여 제어 및 동작이 가능한 범위
// 
// 코루틴 스코프를 만들 때 적용가능한 Dispatcher
// Dispatchers.Default : 기본적인 백그라운드 동작
// Dispatchers.IO : I/O에 최적화된 동작
// Dispatchers.Main : 메인(UI) 스레드에서 동작
// 모든 플랫폼에서 지원되진 않으니, 확인 필요.
// 
// launch는 반환값 없는 Job 객체
// async는 반환값 없는 Deffered 객체

import kotlinx.coroutines.*

fun main() {
    val scope = GlobalScope
    
    scope.launch { // Job 객체의 코루틴
        for(i in 1..5)
        	println(i)
    }
    /* 위 코드까지는
     * 코루틴은 제어되는 스코프 또는 프로그램 전체가 종료되면 함께 종료된다.
     * 따라서 코루틴이 끝까지 실행되는 것을 보장하려면 일정한 범위에서 코루틴이 모두 실행될 때까지 기다려줘야 함
     */ 
     
     /*
      * runBlocking 안에서 launch나 async를 생성하면 코루틴 종료때까지 메인 루틴을 잠시 대기시킴
      * 안드로이드의 메인 스레드에서 runBlocking을 걸면 일정시간 응답이 없을시 ANR 발생
      */ 
      
      runBlocking {
          launch {
              for(i in 1..5)
              	println(i)
          }
      }
      
      // 루틴 대기를 위한 함수들
      // delay: ms 단위로 루틴 잠시 대기 시킴
      // join: job객체 실행 끝날 때까지 대기
      // await: defferred 실행 끝날 때까지 대기. 결과값도 반환함
      // 모두 코루틴 내부 또는 runBlocking 같은 루틴의 대기가 가능한 구문 안에서만 사용 가능

      runBlocking { // 메인 루틴
          val a = launch {
              for(i in 1..5) {
              	println(i)
                delay(10)
              }
          }
          
          val b = async {
              "async done"
          }
          
          println("async 대기")
          println(b.await())
          
          println("launch 대기")
          a.join()
          // a.cancel()
          println("launch 종료")
          
          // 코루틴에 cancel()을 걸면 두 가지 조건이 발생
	      // 1. 코루틴 내부의 delay나 yield 함수가 사용된 위치까지 수행된 뒤 종료됨
    	  // 2. cancel()로 인해 코루틴 내부에서 속성인 isActive가 false가 되므로 이를 확인 후 종료됨
          
          var result = withTimeoutOrNull(50) {
              for(i in 1..10) {
                  println(i)
                  delay(10)
                }
                
                "Finish"
            } // 시간 안에 처리하면 결과값, 못하면 null. join이나 await처럼 blocking 함수

      	    println(result)
	    }
}