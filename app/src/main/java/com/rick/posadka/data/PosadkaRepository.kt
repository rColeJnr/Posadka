package com.rick.posadka.data

import com.rick.posadka.model.PosadkaHole
import com.rick.posadka.model.PosadkaShaft
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PosadkaRepository @Inject constructor(
    private val posadkaHoleDao: PosadkaHoleDao,
    private val posadkaShaftDao: PosadkaShaftDao
) {

    fun getPosadkaShaft(size: Int, name: String): PosadkaShaft {
//        val queryString = "%${name.replace(' ', '%')}%"
        return posadkaShaftDao.getShaftByClass(querySize = size, queryString =name)

    }

    fun getPosadkaHole(size: Int, name: String): PosadkaHole {
//        val queryString = "%${name.replace(' ', '%')}%"
        return posadkaHoleDao.getHoleByClass(querySize = size, queryString = name)
    }
    companion object {

        // For Singleton instantiation
        @Volatile
        private var instance: PosadkaRepository? = null
        fun getInstance(posadkaHoleDao: PosadkaHoleDao, posadkaShaftDao: PosadkaShaftDao) =
            instance ?: synchronized(this) {
                instance ?: PosadkaRepository(posadkaHoleDao, posadkaShaftDao).also {
                    instance = it
                }
            }
    }
}