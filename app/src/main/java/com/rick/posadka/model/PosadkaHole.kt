package com.rick.posadka.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "posadka_hole")
data class PosadkaHole(
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true) val id : Int,
    @ColumnInfo(name = "size")
    val size: Int,
    @ColumnInfo(name = "prevsize" )
    val prevSize: Int,
    @ColumnInfo(name = "class")
    val name: String,
    @ColumnInfo(name = "highdeviation")
    val highDeviation: Float,
    @ColumnInfo(name = "lowdeviaton")
    val lowDeviation: Float

)
