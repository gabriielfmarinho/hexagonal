package com.pix.core.faker

import io.github.serpro69.kfaker.Faker

object FakerInstance {

    private lateinit var faker: Faker

    fun getInstance(): Faker {
        if (!this::faker.isInitialized) {
            faker = Faker()
        }
        return faker
    }

}