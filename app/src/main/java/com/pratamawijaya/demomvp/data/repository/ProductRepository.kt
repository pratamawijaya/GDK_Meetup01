package com.pratamawijaya.demomvp.data.repository

import com.pratamawijaya.demomvp.domain.Product

interface ProductRepository {
    fun getProducts(): List<Product>
}