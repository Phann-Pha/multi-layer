package com.domain.acleda.kh

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import com.domain.acleda.kh.common.base.BaseComponentActivity
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class AppMainActivity : BaseComponentActivity()
{
    private val viewmodel: AppMainViewModel by viewModels()
    
    override fun onCreate(savedInstanceState: Bundle?)
    {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        onChangeIconStatusBarColor(true)
        setContent {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = "Hello world!", Modifier.clickable {
                    viewmodel.onTestNetwork()
                })
                
                onObserveViewModel()
            }
        }
    }
    
    private fun onObserveViewModel()
    {
        lifecycleScope.launch {
            viewmodel.uiState.collectLatest { data ->
                val value = data
            }
        }
    }
}