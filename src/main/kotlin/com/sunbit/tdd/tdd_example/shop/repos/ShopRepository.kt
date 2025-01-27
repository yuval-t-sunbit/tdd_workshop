package com.sunbit.tdd.tdd_example.shop.repos

import org.springframework.stereotype.Repository

data class Shop(val id: Int, val name: String, val address: String)

@Repository
class ShopRepository(
    val shops: MutableMap<Int, Shop> = mutableMapOf()
) {
    fun newShop(id: Int, name: String, address: String) {
        shops[id] = Shop(id, name, address)
    }

    fun getShop(id: Int): Shop {
        return shops[id] ?: throw IllegalArgumentException("Shop not found")
    }
}
