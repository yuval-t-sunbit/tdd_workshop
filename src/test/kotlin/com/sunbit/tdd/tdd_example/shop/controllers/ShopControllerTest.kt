package com.sunbit.tdd.tdd_example.shop.controllers

import com.sunbit.tdd.tdd_example.shop.dtos.ShopDto
import com.sunbit.tdd.tdd_example.shop.services.ShopService
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test


class ShopControllerTest {

    @MockK
    private lateinit var shopService: ShopService

    @InjectMockKs
    private lateinit var shopController: ShopController

    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `getShop - should return shop info`() {
        val expectedShopDto = ShopDto(3, "shop 3", "address 3")
        every { shopService.getShop(expectedShopDto.id) } returns expectedShopDto

        val result = shopController.getShop(expectedShopDto.id)

        assertEquals(expectedShopDto, result)
    }
}