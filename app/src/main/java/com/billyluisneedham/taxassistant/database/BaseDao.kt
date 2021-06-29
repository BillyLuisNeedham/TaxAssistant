package com.billyluisneedham.taxassistant.database

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE

interface BaseDao<T> {
    @Insert(onConflict = REPLACE)
    fun insert(vararg obj: T)

    @Delete
    fun delete(obj: T)
}