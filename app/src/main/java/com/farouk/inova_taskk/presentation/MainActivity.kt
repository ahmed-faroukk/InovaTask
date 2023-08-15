package com.farouk.inova_taskk.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.farouk.inova_taskk.common.connectivityObserver.ConnectivityObserver
import com.farouk.inova_taskk.common.connectivityObserver.NetworkConnectivityObserver
import com.farouk.inova_taskk.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var connectivityObserver: ConnectivityObserver
    private var lost: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        checkNetwork()
    }


   private fun checkNetwork() {
        connectivityObserver = NetworkConnectivityObserver(applicationContext)
        connectivityObserver.observe().onEach { it ->
            if (it.toString() == "Lost" || it.toString() == "Losing" || it.toString() == "Unavailable") {
                //start destination
                Toast.makeText(applicationContext, "lost Connection", Toast.LENGTH_LONG).show()
                lost = true

            } else {
                if (lost)
                    Toast.makeText(applicationContext, "back online", Toast.LENGTH_LONG).show()
            }
        }.launchIn(lifecycleScope)
    }
}