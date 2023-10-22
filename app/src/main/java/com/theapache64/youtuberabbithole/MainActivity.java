package com.theapache64.youtuberabbithole;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends Activity {

    private static final List<String> goodApps = new ArrayList<>();

    static {
        goodApps.add("com.quora.android"); // Quora
        goodApps.add("com.google.android.apps.books"); // Google Books
        // add as many good apps here
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String packageName = getRandomPackageName();
        Intent appIntent = getPackageManager().getLaunchIntentForPackage(packageName);

        if (appIntent == null) {
            // App not installed, so let's redirect to the store
            appIntent = new Intent(Intent.ACTION_VIEW);
            appIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            appIntent.setData(Uri.parse("market://details?id=" + packageName));
        }

        startActivity(appIntent);
        finish();
    }

    private String getRandomPackageName() {
        Random random = new Random();
        int index = random.nextInt(goodApps.size());
        return goodApps.get(index);
    }
}