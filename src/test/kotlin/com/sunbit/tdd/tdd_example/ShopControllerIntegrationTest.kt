package com.sunbit.tdd.tdd_example

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.sunbit.tdd.tdd_example.shop.dtos.ShopDto
import com.sunbit.tdd.tdd_example.shop.repos.ShopRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate
import kotlin.test.assertEquals

@Configuration
class TestConfig {
    @Bean
    fun restTemplate(): RestTemplate {
        return RestTemplate()
    }
}

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ShopControllerIntegrationTest {

    @LocalServerPort
    private val port: Int = 0

    @Autowired
    private lateinit var restTemplate: RestTemplate

    @Autowired
    private lateinit var shopRepository: ShopRepository

    @Test
    fun `should return shop info`() {
        val expectedShopInfo = ShopDto(3, "shop 3", "address 3")
        shopRepository.newShop(expectedShopInfo.id, expectedShopInfo.name, expectedShopInfo.address)

        val response =
            restTemplate.getForEntity("http://localhost:$port/shops/shop/${expectedShopInfo.id}", String::class.java)

        assert(response.statusCode.is2xxSuccessful)
        val objectMapper = jacksonObjectMapper()
        assertEquals(expectedShopInfo, objectMapper.readValue(response.body, ShopDto::class.java))
    }
}
