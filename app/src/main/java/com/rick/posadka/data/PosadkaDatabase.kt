package com.rick.posadka.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.rick.posadka.model.PosadkaHole
import com.rick.posadka.model.PosadkaShaft

@Database(entities = [PosadkaHole::class, PosadkaShaft::class], version = 1, exportSchema = true)
abstract class PosadkaDatabase: RoomDatabase() {
    abstract fun posadkaHoleDao(): PosadkaHoleDao
    abstract fun posadkaShaftDao(): PosadkaShaftDao

    companion object {
        private const val DATABASE_NAME = "pasadki.db"

        // For singleton initialization
        @Volatile private var instance: PosadkaDatabase? = null

        fun getInstance(context: Context): PosadkaDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        // create and pre-populate the db
        private fun buildDatabase(context: Context): PosadkaDatabase {
            return Room.databaseBuilder(context, PosadkaDatabase::class.java, DATABASE_NAME)
                .createFromAsset("database/pasadki.db")
                .build()
        }
    }
}

