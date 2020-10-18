@file:Suppress("ClassName")

package my.demo.webmvc

import io.kotest.core.spec.style.StringSpec
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext

@SpringBootTest
class WaitControllerTest_UseMockMvc(
    private val webApplicationContext: WebApplicationContext
) : StringSpec({
    val mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
        .build()

    "/wait/delay" {
        mockMvc.perform(MockMvcRequestBuilders.get("/wait/delay"))
            .andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.content().bytes(ByteArray(0)))
    }
})
