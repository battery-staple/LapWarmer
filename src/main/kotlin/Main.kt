import java.util.concurrent.atomic.AtomicInteger
import kotlin.concurrent.thread

fun main(args: Array<String>) {
    val x = AtomicInteger(0)

    repeat(100) {
        thread {
            println("Launching thread #$it")
            while (true)
                println("Thread #${it.toString().padStart(2, '0')}: ${x.getAndIncrement()}")
        }
    }
}