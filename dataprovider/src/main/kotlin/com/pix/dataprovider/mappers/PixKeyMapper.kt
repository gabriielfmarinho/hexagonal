package com.pix.dataprovider.mappers

import com.pix.core.entities.PixKey
import com.pix.core.entities.TypePixKey
import com.pix.dataprovider.entities.DynamoPixKey

fun PixKey.toDynamoPixKey() = DynamoPixKey(
    pk = "PIXKEY:$key",
    sk = account,
    key = key,
    account = account,
    type = type.name
)

fun DynamoPixKey.toPixKey() = PixKey(
    key = key!!,
    account = account!!,
    type = TypePixKey.valueOf(type!!)
)