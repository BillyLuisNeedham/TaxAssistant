package com.billyluisneedham.taxassistant.data

import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE

interface BaseDao<T> {
    @Insert(onConflict = REPLACE)
    fun insert(vararg obj: T)
}