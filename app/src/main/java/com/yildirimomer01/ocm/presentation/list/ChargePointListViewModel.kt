package com.yildirimomer01.ocm.presentation.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yildirimomer01.ocm.core.*
import com.yildirimomer01.ocm.core.common.PoiChannelState
import com.yildirimomer01.ocm.core.common.Resource
import com.yildirimomer01.ocm.domain.model.ChargePointListItemUiModel
import com.yildirimomer01.ocm.domain.usecase.GetInitialChannelParamsUseCase
import com.yildirimomer01.ocm.domain.usecase.FetchPoiListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@OptIn(ExperimentalCoroutinesApi::class)
@HiltViewModel
class ChargePointListViewModel @Inject constructor(
    private val fetchPoiListUseCase: FetchPoiListUseCase,
    private val initialChannelParamsUseCase: GetInitialChannelParamsUseCase
) : ViewModel() {

    private val _viewState = MutableStateFlow(ChargePointListScreenState())
    val viewState = _viewState.asStateFlow()

    private val _channelState = MutableStateFlow(PoiChannelState.Enabled)
    private val channelState = _channelState.asStateFlow()

    init {
        getPoiList()
    }

    /**
     *  fetch poi list
     */
    private fun getPoiList() {
        _viewState.update { currentState ->
            currentState.copy(isLoading = true)
        }
        viewModelScope.launch {
            fetchPoiListUseCase.fetch(initialChannelParamsUseCase.invoke(::isChannelCancelled)).collectLatest { resource ->
                checkResourceState(resource)
            }
        }
    }

    /**
     * check received data state
     */
    private fun checkResourceState(resource: Resource<List<ChargePointListItemUiModel>>) {
        when (resource) {
            is Resource.Error -> {
                _viewState.update { currentState ->
                    currentState.copy(isLoading = false, error = currentState.error)
                }
            }
            is Resource.Loading -> {
                _viewState.update { currentState ->
                    currentState.copy(isLoading = true)
                }
            }
            is Resource.Success -> {
                _viewState.update { currentState ->
                    currentState.copy(isLoading = false, poiList = resource.data.orEmpty())
                }
            }
        }
    }


    /**
     *  if the channel is enabled, keep open the channel
     */
    private fun isChannelCancelled() = channelState.value != PoiChannelState.Enabled

}