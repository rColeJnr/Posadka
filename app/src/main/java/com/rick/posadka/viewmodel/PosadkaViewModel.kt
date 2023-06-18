package com.rick.posadka.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rick.posadka.data.PosadkaRepository
import com.rick.posadka.model.PosadkaHole
import com.rick.posadka.model.PosadkaShaft
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PosadkaViewModel @Inject internal constructor(
    private val posadkaRepository: PosadkaRepository
) : ViewModel() {

    private val _posadkaHole: MutableLiveData<PosadkaHole> = MutableLiveData()
    val posadkaHole: LiveData<PosadkaHole> get() = _posadkaHole
    private val _posadkaShaft: MutableLiveData<PosadkaShaft> = MutableLiveData()
    val posadkaShaft: LiveData<PosadkaShaft> get() = _posadkaShaft

    fun getPosadkaHole(size: Int, name: String) {
        viewModelScope.launch(Dispatchers.IO) {
            posadkaRepository.getPosadkaHole(size, name).collect {
                _posadkaHole.postValue(it)
            }
        }
    }

    fun getPosadkaShaft(size: Int, name: String) {
        viewModelScope.launch(Dispatchers.IO) {
            posadkaRepository.getPosadkaShaft(size, name).collect {
                _posadkaShaft.postValue(it)
            }
        }
    }

}