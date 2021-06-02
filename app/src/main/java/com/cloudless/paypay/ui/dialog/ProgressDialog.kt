package com.cloudless.paypay.ui.dialog

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import com.cloudless.paypay.R

class ProgressDialog(private val activity: Activity){
    private var dialog: AlertDialog? = null

    fun startLoadingDialog(){
        val builder = AlertDialog.Builder(activity)
        val inflater: LayoutInflater = activity.layoutInflater
        builder.setView(inflater.inflate(R.layout.custom_dialog, null))
        builder.setCancelable(false)
        dialog = builder.create()
        dialog?.show()
    }

    fun dismiss(){
        dialog!!.dismiss()
    }
}