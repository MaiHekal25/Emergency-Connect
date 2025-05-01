package com.training.emergencyapp

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.training.emergencyapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var onBackPressedCallback: OnBackPressedCallback
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Data Source --> ArrayList
        var emergencies = ArrayList<EmergencyModel>()
        emergencies.add(EmergencyModel(R.drawable.ic_police, getString(R.string.police), "122"))
        emergencies.add(EmergencyModel(R.drawable.ic_fire, getString(R.string.fire_truck), "180"))
        emergencies.add(EmergencyModel(R.drawable.ic_child,
            getString(R.string.child_rescue), "16000"))

        //Adapter
        val adapter = EmergencyAdapter(this, emergencies)
        binding.recycler.adapter = adapter

        // Register callback in onCreate
        onBackPressedCallback = object : OnBackPressedCallback(true) { // true means initially enabled
            override fun handleOnBackPressed() {
                // Your custom back press logic here
                val exitDialog = ExitDialog()
                exitDialog.isCancelable = false
                exitDialog.show(supportFragmentManager, null)
            }
        }
        onBackPressedDispatcher.addCallback(this, onBackPressedCallback)
        
    }
    override fun onDestroy() {
        super.onDestroy()
        onBackPressedCallback.remove()
    }
}