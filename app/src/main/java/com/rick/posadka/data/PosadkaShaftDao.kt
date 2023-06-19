package com.rick.posadka.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rick.posadka.model.PosadkaShaft
import kotlinx.coroutines.flow.Flow

@Dao
interface PosadkaShaftDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertShaft(posadkaShaft: PosadkaShaft)

    @Query(
        "SELECT * FROM posadka_shaft ORDER BY class ASC"
    )
    suspend fun getAllShafts(): List<PosadkaShaft>

    @Query(
        "SELECT * FROM posadka_shaft WHERE class LIKE :queryString " +
                "AND :querySize < size AND :querySize >= prev_size"
    )
    fun getShaftByClass(queryString: String, querySize: Float): Flow<PosadkaShaft>
}