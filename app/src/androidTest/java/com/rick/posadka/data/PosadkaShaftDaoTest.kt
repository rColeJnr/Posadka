package com.rick.posadka.data

import android.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.rick.posadka.model.PosadkaShaft
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class PosadkaShaftDaoTest {
    private lateinit var database: PosadkaDatabase
    private lateinit var shaftDao: PosadkaShaftDao
    private lateinit var testPosadkaShaft: PosadkaShaft

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
        shaftDao = database.posadkaShaftDao()
        // expected result from database
        testPosadkaShaft = PosadkaShaft(
            1,
            26f,
            30,
            "d9",
            -0.3f,
            -0.384f,
        )

        database.posadkaShaftDao().insertShaft(testPosadkaShaft)
    }

    @After
    fun closeDb() {
        database.close()
    }

    @Test
    fun testGetHoleByClass() = runBlocking {

        val posadka = shaftDao.getShaftByClass("a9", 46f).first().name
        Assert.assertTrue(posadka == testPosadkaShaft.name)

    }
}