// observer = listener

fun main() {
    EventPrinter().start()
    println()
    EventPrinter2().start()
}

interface EventListener {
    fun onEvent(count: Int) // on은 알고 있듯이 관례.
}

class Counter(var listener: EventListener) {
    fun count() {
        for(i in 1..100) {
            if(i % 5 == 0) listener.onEvent(i)
        }
    }
}

class EventPrinter: EventListener {
    override fun onEvent(count: Int) {
        print("${count} - ")
    }
    
    fun start() {
        val counter = Counter(this) // 업캐스팅
        counter.count()
    }
}

class EventPrinter2 {
    fun start() {
        var counter = Counter(object: EventListener { // 익명 객체, 즉시 생성
            override fun onEvent(count:Int) {
		        print("${count} = ")       
            }
        })
        
        counter.count()
    }
}