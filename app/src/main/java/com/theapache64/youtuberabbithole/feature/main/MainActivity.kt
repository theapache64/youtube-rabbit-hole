package com.theapache64.youtuberabbithole.feature.main

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    companion object {
        private val goodApps = listOf(
                "com.quora.android", // Quora
                "com.google.android.apps.books", // Google Books
                // add as many good apps here
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val packageName = goodApps.random()
        var appIntent = packageManager.getLaunchIntentForPackage(packageName)

        if (appIntent == null) {
            // app not installed, so let's redirect to store
            appIntent = Intent(Intent.ACTION_VIEW).apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                data = Uri.parse("market://details?id=$packageName")
            }
        }

        startActivity(appIntent)
        finish()
    }
}