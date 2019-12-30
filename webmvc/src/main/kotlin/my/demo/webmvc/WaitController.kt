package my.demo.webmvc

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/wait") @RestController
class WaitController {
    @GetMapping("/sleep")
    fun sleep() {
        Thread.sleep(1000)
    }

    @GetMapping("/delay")
    fun delayFun(): Unit = runBlocking {
        delay(1000)
    }
}
