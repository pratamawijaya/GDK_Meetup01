package com.pratamawijaya.demomvp.data.repository

import com.pratamawijaya.demomvp.domain.Product

class ProductRepositoryImpl : ProductRepository {
    override fun getProducts(): List<Product> {
        // do something to get product

        return emptyList()
    }
}