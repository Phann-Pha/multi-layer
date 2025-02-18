package com.domain.acleda.kh

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.domain.acleda.data.helper.util.Resource
import com.domain.acleda.domain.AppMainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class AppMainViewModel @Inject constructor(private val repository: AppMainRepository) : ViewModel()
{
    private val _loadingAnimation: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val loadingAnimation: StateFlow<Boolean> get() = _loadingAnimation
    
    private val _uiState: MutableStateFlow<String?> = MutableStateFlow(null)
    val uiState: StateFlow<String?> get() = _uiState.asStateFlow()
    
    fun onTestNetwork()
    {
        repository.onTestNetwork().onEach { response ->
            when (response)
            {
                is Resource.Success ->
                {
                    try
                    {
                        _loadingAnimation.emit(false)
                        val rawValue = response.data?.string() ?: ""
                        _uiState.emit(rawValue)
                    }
                    catch (e: Exception)
                    {
                        _loadingAnimation.emit(false)
                        e.printStackTrace()
                    }
                }
                
                is Resource.Error ->
                {
                    _loadingAnimation.emit(false)
                }
            }
            
        }.launchIn(viewModelScope)
    }
}