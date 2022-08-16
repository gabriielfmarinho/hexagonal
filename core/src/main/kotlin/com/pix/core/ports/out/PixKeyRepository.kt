package com.pix.core.ports.out

import com.pix.core.entities.PixKey

interface PixKeyRepository {
    fun save(pixKey: PixKey): PixKey
}