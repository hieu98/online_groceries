package com.hdt.booking.utils

import android.os.Build
import android.view.View
import androidx.annotation.RequiresApi
import com.hdt.booking.extension.nowUtcMillis

private const val SAFE_INTERVAL = 750

class SafeOnClickListener(
    private val isSafe: Boolean,
    private val action: (view: View) -> Unit
) : View.OnClickListener {
    private var lastClickTimestamp = 0L

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onClick(clickedView: View) {
        if (!isSafe) {
            action(clickedView)
            return
        }

        val currentTimestamp = nowUtcMillis()
        if (lastClickTimestamp == 0L || currentTimestamp - lastClickTimestamp > SAFE_INTERVAL) {
            action(clickedView)
            lastClickTimestamp = currentTimestamp
        }
    }
}