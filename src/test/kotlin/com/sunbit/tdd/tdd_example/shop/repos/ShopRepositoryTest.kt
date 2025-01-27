package com.sunbit.tdd.tdd_example.shop.repos

import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.InjectMockKs
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach

class ShopRepositoryTest {

    @InjectMockKs
    private lateinit var shopRepository: ShopRepository

    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `getShop - returns shop for shop id`() {
        val expectedShop = Shop(3, "shop 3", "address 3")
        shopRepository.shops[expectedShop.id] = expectedShop

        val result = shopRepository.getShop(expectedShop.id)

        assertEquals(expectedShop, result)
    }

    @Test
    fun `getShop - throws exception when shop not found`() {
        assertThrows(IllegalArgumentException::class.java) {
            shopRepository.getShop(1)
        }
    }
}