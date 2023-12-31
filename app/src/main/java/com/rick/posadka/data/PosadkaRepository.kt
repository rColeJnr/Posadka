package com.rick.posadka.data

import com.rick.posadka.model.PosadkaHole
import com.rick.posadka.model.PosadkaShaft
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PosadkaRepository @Inject constructor(
    private val posadkaHoleDao: PosadkaHoleDao,
    private val posadkaShaftDao: PosadkaShaftDao
) {

    fun getPosadkaShaft(size: Float, name: String): Flow<PosadkaShaft> {
        val queryString = "%${name.replace(' ', '%')}%"
        return posadkaShaftDao.getShaftByClass(querySize = size, queryString =queryString)

    }

    fun getPosadkaHole(size: Float, name: String): Flow<PosadkaHole> {
        val queryString = "%${name.replace(' ', '%')}%"
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