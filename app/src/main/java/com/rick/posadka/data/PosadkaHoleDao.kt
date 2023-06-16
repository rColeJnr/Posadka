package com.rick.posadka.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rick.posadka.model.PosadkaHole

@Dao
interface PosadkaHoleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHole(posadkaHole: PosadkaHole)

    @Query("SELECT * FROM posadka_hole ORDER BY class ASC")
    fun getAllHoles(): List<PosadkaHole>

    @Query("SELECT * FROM posadka_hole WHERE class LIKE :queryString " +
            "AND size LIKE :querySize")
    fun getHoleByClass(queryString: String, querySize: Int): PosadkaHole
}