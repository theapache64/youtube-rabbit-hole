package com.theapache64.youtuberabbithole

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    companion object {
        private val usefulApps = listOf(
                "com.quora.android", // Quora
                "com.google.android.apps.books", // Google Books
                // add as many good apps here
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val packageName = usefulApps.random()
        var appIntent = packageManager.getLaunchIntentForPackage(packageName)

        if (appIntent == null) {
            // app not installed, so let's redirect to play store
            appIntent = Intent(Intent.ACTION_VIEW).apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                data = Uri.parse("market://details?id=$packageName")
            }
        }

        startActivity(appIntent)
        finish()
    }
}