package com.sunbit.tdd.tdd_example.shop.services

import com.sunbit.tdd.tdd_example.shop.dtos.ShopDto
import com.sunbit.tdd.tdd_example.shop.repos.Shop
import com.sunbit.tdd.tdd_example.shop.repos.ShopRepository
import org.springframework.stereotype.Service

@Service
class ShopService(private val shopRepository: ShopRepository) {
    fun getShop(id: Int): ShopDto {
        return shopToShopDto(shopRepository.getShop(id))
    }

    private fun shopToShopDto(shop: Shop): ShopDto {
        return ShopDto(shop.id, shop.name, shop.address)
    }
}
