package my.demo.webmvcAsync

import org.springframework.scheduling.TaskScheduler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.OffsetDateTime
import java.util.concurrent.CompletableFuture

@RequestMapping("/wait") @RestController
class WaitController(
    private val taskScheduler: TaskScheduler
) {
    @GetMapping("/delay")
    fun delayFun(): CompletableFuture<Unit> =
        CompletableFuture<Unit>().also {
            taskScheduler.schedule(
                { it.complete(null) },
                OffsetDateTime.now().plusSeconds(1).toInstant()
            )
        }
}
