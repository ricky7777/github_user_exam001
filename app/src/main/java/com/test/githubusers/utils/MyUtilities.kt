package com.test.githubusers.utils

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.View
import android.view.ViewGroup.MarginLayoutParams
import android.widget.GridView
import android.widget.TextView
import com.test.githubusers.view.DetailCell
import java.text.SimpleDateFormat
import java.util.*

// 提供常用的工具

class MyUtilities {

    companion object {

        private val TAG = MyUtilities::class.java.simpleName

        fun dpToPx(dp: Int, context: Context): Int {
            return (dp * context.resources.displayMetrics.density).toInt()
        }

        fun setDynamicHeight(gridView: GridView, dp: Int, context: Context) {
            //Log.d(TAG, "setDynamicHeight, dp=" + dp)
            val params = gridView.layoutParams
            params.height = dpToPx(dp, context)
            Log.d(TAG, "setDynamicHeight, height=" + params.height)
            gridView.layoutParams = params
        }




    }
    
}





