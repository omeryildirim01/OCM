package com.yildirimomer01.ocm.presentation.detail

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yildirimomer01.ocm.core.common.Constants
import com.yildirimomer01.ocm.core.common.Resource
import com.yildirimomer01.ocm.domain.usecase.GetChargePointUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChargePointDetailViewModel @Inject constructor(
    private val getChargePointUseCase: GetChargePointUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

   private val _state = mutableStateOf(ChargePointDetailScreenState())
   val state: State<ChargePointDetailScreenState> = _state

    init {
        _state.value = ChargePointDetailScreenState(isLoading = true)
        val poiId = savedStateHandle.get<String>(Constants.PARAM_POI_ID)
        poiId?.let {
            getChargePointDetails(poiId)
        }
    }


    private fun getChargePointDetails(poiId: String) {
        viewModelScope.launch {
            when (val result = getChargePointUseCase.invoke(poiId.toLong())) {
                is Resource.Error -> _state.value = ChargePointDetailScreenState(error = result.message ?: "An unexpected error occurred")
                is Resource.Loading -> _state.value = ChargePointDetailScreenState(isLoading = true)
                is Resource.Success -> _state.value = ChargePointDetailScreenState(chargePoint = result.data)
            }
        }
    }
}