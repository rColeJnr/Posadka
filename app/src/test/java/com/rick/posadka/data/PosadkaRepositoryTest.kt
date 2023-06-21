package com.rick.posadka.data

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.rick.posadka.model.PosadkaHole
import com.rick.posadka.model.PosadkaShaft
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith


class PosadkaRepositoryTest() {

    private lateinit var database: PosadkaDatabase
    private lateinit var shaftDao: PosadkaShaftDao
    private lateinit var holeDao: PosadkaHoleDao

    @Before
    fun setupDatabase() {
        val context = ApplicationProvider.getApplicationContext<Context>()

        database = Room.inMemoryDatabaseBuilder(
            context,
            PosadkaDatabase::class.java
        )
            .allowMainThreadQueries()
            .createFromAsset("database/pasadki.db")
            .build()

        shaftDao = database.posadkaShaftDao()
        holeDao = database.posadkaHoleDao()
    }

    @After
    fun closeDatabase() {
        database.close()
    }

    @Test
    fun `get shaft by class`() = runBlocking {
        // expected result from database
        val shaft = PosadkaShaft(
            1,
            26f,
            30,
            "a9",
            -0.3f,
            -0.384f,
        )

        val posadka = shaftDao.getShaftByClass("a9", 26f).first()
        assertEquals(shaft, posadka)
    }

    @Test
    fun `get hole by class`() = runBlocking {
        // expected result from database
        val hole = PosadkaHole(
            1,
            26f,
            30,
            "a9",
            -0.3f,
            -0.384f,
        )

        val posadka = holeDao.getHoleByClass("d9", 26f).first()
        assertEquals(hole, posadka)
    }
}

