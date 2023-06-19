package com.rick.posadka.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rick.posadka.model.PosadkaHole
import kotlinx.coroutines.flow.Flow

@Dao
interface PosadkaHoleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHole(posadkaHole: PosadkaHole)

    @Query("SELECT * FROM posadka_hole ORDER BY class ASC")
    suspend fun getAllHoles(): List<PosadkaHole>

    @Query("SELECT * FROM posadka_hole WHERE class LIKE :queryString " +
            "AND :querySize < size AND :querySize >= prevsize")
    fun getHoleByClass(queryString: String, querySize: Int): Flow<PosadkaHole>
}