package com.rick.posadka.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "posadka_shaft")
data class PosadkaShaft(
    @PrimaryKey(autoGenerate = false) val id : Int,
    val size: Int,
    @ColumnInfo(name = "class")
    val name: String,
    val highDeviation: Int,
    val lowDeviation: Int
)
