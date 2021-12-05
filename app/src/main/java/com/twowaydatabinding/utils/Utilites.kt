package com.twowaydatabinding.utils

import android.content.Context
import android.net.ConnectivityManager

object Utilites {

    fun isNetWorkAvailable(context: Context) : Boolean{
        val connectivityManager : ConnectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netWorkInfo = connectivityManager.activeNetworkInfo
        return netWorkInfo != null && netWorkInfo.isConnected

    }
}