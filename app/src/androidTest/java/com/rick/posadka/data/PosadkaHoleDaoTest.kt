package com.rick.posadka.data

import android.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.rick.posadka.model.PosadkaHole
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class PosadkaHoleDaoTest {
    private lateinit var database: PosadkaDatabase
    private lateinit var holeDao: PosadkaHoleDao
    private lateinit var testPosadkaHole: PosadkaHole

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun createDb() = runBlocking {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        database = Room.inMemoryDatabaseBuilder(
            context,
            PosadkaDatabase::class.java
        )
            .build()
        holeDao = database.posadkaHoleDao()
        // expected result from database
        testPosadkaHole = PosadkaHole(
            1,
            26f,
            30,
            "d9",
            -0.3f,
            -0.384f,
        )

        database.posadkaHoleDao().insertHole(testPosadkaHole)
    }

    @After
    fun closeDb() {
        database.close()
    }

    @Test
    fun testGetHoleByClass() = runBlocking {

        val posadka = holeDao.getHoleByClass("d9", 26f).first().name
        assertTrue(posadka == testPosadkaHole.name)

    }
}