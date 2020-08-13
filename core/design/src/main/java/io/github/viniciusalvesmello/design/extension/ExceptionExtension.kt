package io.github.viniciusalvesmello.design.extension

import android.content.Context
import android.content.pm.ApplicationInfo

fun Exception.isDebuggable(context: Context, execute: (e: Exception) -> Unit = {}): Boolean {
    if(0 != context.applicationInfo.flags and ApplicationInfo.FLAG_DEBUGGABLE) {
        execute(this)
        return true
    }
    return false
}