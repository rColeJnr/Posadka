package com.rick.posadka.data

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PosadkaRepository @Inject constructor(
    private val posadkaHoleDao: PosadkaHoleDao,
    private val posadkaShaftDao: PosadkaShaftDao
) {

    fun getPosadkaShaft(size: Int, name: String) =
        posadkaShaftDao.getShaftByClass(querySize = size, queryString = name)

    fun getPosadkaHole(size: Int, name: String) =
        posadkaHoleDao.getHoleByClass(querySize = size, queryString = name)

    companion object {

        // For Singleton instantiation
        @Volatile private var instance: PosadkaRepository? = null
        fun getInstance(posadkaHoleDao: PosadkaHoleDao, posadkaShaftDao: PosadkaShaftDao) =
            instance ?: synchronized(this) {
                instance ?: PosadkaRepository(posadkaHoleDao, posadkaShaftDao).also { instance = it }
            }
    }
}