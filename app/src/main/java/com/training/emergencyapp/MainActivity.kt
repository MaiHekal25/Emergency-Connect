package com.training.emergencyapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.training.emergencyapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Data Source --> ArrayList
        var emergencies = ArrayList<EmergencyModel>()
        emergencies.add(EmergencyModel(R.drawable.ic_police, "Police", "122"))
        emergencies.add(EmergencyModel(R.drawable.ic_fire, "Fire Truck", "180"))
        emergencies.add(EmergencyModel(R.drawable.ic_child, "Child Rescue", "16000"))

        //Adapter
        val adapter = EmergencyAdapter(this, emergencies)
        binding.recycler.adapter = adapter
    }
}