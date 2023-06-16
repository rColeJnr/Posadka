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
    fun getAllShafts(): List<PosadkaShaft>

    @Query(
        "SELECT class FROM posadka_shaft WHERE class LIKE :queryString " +
                "AND size LIKE :querySize"
    )
    fun getShaftByClass(queryString: String, querySize: Int): PosadkaShaft
}