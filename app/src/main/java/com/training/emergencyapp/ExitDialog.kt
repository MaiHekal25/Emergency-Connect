package com.training.emergencyapp

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class ExitDialog: DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        //build dialog using Builder
        val builder = AlertDialog.Builder(activity)
        builder.setIcon(android.R.drawable.ic_dialog_alert)
            .setTitle("Exit")
            .setMessage("Are you sure you want to exit?")
            .setPositiveButton("Yes") { dialog, which -> activity?.finish()}
            .setNegativeButton("cancel", null)
            //.setNegativeButton("No") { dialog, _ -> dialog.dismiss()}
        return builder.create()
    }
}