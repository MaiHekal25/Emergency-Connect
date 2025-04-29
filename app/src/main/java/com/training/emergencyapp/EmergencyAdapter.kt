package com.training.emergencyapp

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.training.emergencyapp.databinding.EmergencyListItemBinding
import androidx.core.net.toUri

class EmergencyAdapter(val activity: Activity, val emergencies: ArrayList<EmergencyModel>)
    : RecyclerView.Adapter<EmergencyAdapter.EmergencyViewHolder>() {

        class EmergencyViewHolder(val binding: EmergencyListItemBinding) : RecyclerView.ViewHolder(binding.root){
            val image = binding.image
            val text = binding.text
            val parent = binding.parent
        }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EmergencyAdapter.EmergencyViewHolder {
        val binding = EmergencyListItemBinding.inflate(activity.layoutInflater, parent, false)
        return EmergencyViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: EmergencyAdapter.EmergencyViewHolder,
        position: Int
    ) {
        holder.text.text = emergencies[position].name
        holder.image.setImageResource(emergencies[position].image)
        holder.parent.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, "tel:${emergencies[position].phoneNumber}".toUri())
            activity.startActivity(intent)
        }
    }

    override fun getItemCount() = emergencies.size
}