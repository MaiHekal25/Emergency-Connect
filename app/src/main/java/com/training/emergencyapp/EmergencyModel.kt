package com.training.emergencyapp

import androidx.annotation.DrawableRes

class EmergencyModel (
    @DrawableRes val image: Int,
    val name: String,
    val phoneNumber: String
)