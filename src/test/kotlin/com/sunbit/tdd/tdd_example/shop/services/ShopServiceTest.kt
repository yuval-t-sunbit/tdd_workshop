package com.sunbit.tdd.tdd_example.shop.services

import com.sunbit.tdd.tdd_example.shop.dtos.ShopDto
import com.sunbit.tdd.tdd_example.shop.repos.Shop
import com.sunbit.tdd.tdd_example.shop.repos.ShopRepository
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach

class ShopServiceTest {

    @MockK
    private lateinit var shopRepository: ShopRepository

    @InjectMockKs
    private lateinit var shopService: ShopService

    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `getShop - returns shop info for shop id`() {
        val expectedShopDto = ShopDto(3, "shop 3", "address 3")
        every { shopRepository.getShop(expectedShopDto.id) } returns Shop(expectedShopDto.id, expectedShopDto.name, expectedShopDto.address)

        shopService.getShop(expectedShopDto.id)

        assertEquals(expectedShopDto, shopService.getShop(expectedShopDto.id))
    }
}