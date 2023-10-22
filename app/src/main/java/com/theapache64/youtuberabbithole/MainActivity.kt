package com.theapache64.youtuberabbithole

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import java.util.*

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val packageName = randomPackageName
        var appIntent = packageManager.getLaunchIntentForPackage(packageName)
        if (appIntent == null) {
            // App not installed, so let's redirect to the store
            appIntent = Intent(Intent.ACTION_VIEW)
            appIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            appIntent.data = Uri.parse("market://details?id=$packageName")
        }
        startActivity(appIntent)
        finish()
    }

    private val randomPackageName: String
        get() {
            val random = Random()
            val index = random.nextInt(goodApps.size)
            return goodApps[index]
        }

    companion object {
        private val goodApps: MutableList<String> = ArrayList()

        init {
            goodApps.add("com.quora.android") // Quora
            goodApps.add("com.google.android.apps.books") // Google Books
            // add as many good apps here
        }
    }
}