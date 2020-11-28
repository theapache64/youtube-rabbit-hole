package com.theapache64.youtuberabbithole

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.intent.Intents
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.theapache64.expekt.should
import com.theapache64.youtuberabbithole.feature.main.MainActivity
import junit.framework.TestCase
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by theapache64 : Nov 28 Sat,2020 @ 10:01
 */
@RunWith(AndroidJUnit4::class)
class MainActivityTest : TestCase() {
    @Test
    fun givenMain_whenAppLaunched_thenIntentShouldFire() {
        Intents.init()
        ActivityScenario.launch(MainActivity::class.java)

        // should fire two intents
        val firedIntents = Intents.getIntents()
        firedIntents.size.should.equal(2)
    }
}