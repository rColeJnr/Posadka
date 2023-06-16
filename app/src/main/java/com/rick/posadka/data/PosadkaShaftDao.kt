package com.rick.posadka.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rick.posadka.model.PosadkaShaft

@Dao
interface PosadkaShaftDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertShaft(posadkaShaft: PosadkaShaft)

    @Query(
        "SELECT * FROM posadka_shaft ORDER BY class ASC"
    )
    suspend fun getAllShafts(): List<PosadkaShaft>

    @Query(
        "SELECT class FROM posadka_shaft WHERE size LIKE :queryString " +
                "AND size LIKE :querySize"
    )
    suspend fun getShaftByClass(queryString: String, querySize: Int): PosadkaShaft
}