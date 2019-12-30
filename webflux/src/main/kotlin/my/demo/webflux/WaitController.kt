package my.demo.webflux

import kotlinx.coroutines.delay
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/wait") @RestController
class WaitController {
    @GetMapping("/delay")
    suspend fun delayFun() {
        delay(1000)
    }
}
