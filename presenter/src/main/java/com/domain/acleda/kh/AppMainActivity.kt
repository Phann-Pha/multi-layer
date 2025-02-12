package com.domain.acleda.kh

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.domain.acleda.kh.common.BaseComponentActivity

class AppMainActivity : BaseComponentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        onChangeIconStatusBarColor(true)
        setContent {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = "Hello world!")
            }
        }
    }
}