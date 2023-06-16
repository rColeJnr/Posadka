package com.rick.posadka.data

import androidx.room.Database
import com.rick.posadka.model.PosadkaHole
import com.rick.posadka.model.PosadkaShaft

@Database(entities = [PosadkaHole::class, PosadkaShaft::class], version = 1)
abstract class PosadkaDatabase {
    abstract fun posadkaDao(): PosadkaHoleDao
}