@file:Suppress("ClassName")

package my.demo.webmvc

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.shouldBe
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class WaitControllerTest_UseRestTemplate(
    private val restTemplate: TestRestTemplate
) : StringSpec({
    "/wait/delay" {
        val response = restTemplate.getForEntity("/wait/delay", Void::class.java)
        response.statusCode shouldBe HttpStatus.OK
        response.hasBody().shouldBeFalse()
    }
})
