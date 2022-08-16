package com.pix.core.entities

import com.pix.core.entities.AccountStatus.ACTIVE
import com.pix.core.entities.AccountType.CURRENT

data class Account(
    val agency: String,
    val number: String,
    val operation: String,
    var status: AccountStatus = ACTIVE,
    var type: AccountType = CURRENT,
    val person: Person,
) {

    fun accountIsActive(): Boolean {
        return ACTIVE == status
    }
}