package com.sunbit.tdd.tdd_example.shop.controllers

import com.sunbit.tdd.tdd_example.shop.dtos.ShopDto
import com.sunbit.tdd.tdd_example.shop.services.ShopService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/shops")
class ShopController(
    val shopService: ShopService
) {
    @GetMapping("/shop/{shopId}")
    fun getShop(@PathVariable shopId: Int): ShopDto {
        return shopService.getShop(shopId)
    }
}