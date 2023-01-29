package com.ilya.sporttest.presentation.di

import android.app.Application
import com.ilya.sporttest.data.di.DaggerApplicationComponent
import com.onesignal.OneSignal

class SportAppApplication: Application() {
    val component by lazy { DaggerApplicationComponent.factory().create(this) }

    private val ONESIGNAL_APP_ID = "3966b381-f35f-421c-a199-bb92c73e4045"

    override fun onCreate() {
        super.onCreate()

        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE);

        OneSignal.initWithContext(this);
        OneSignal.setAppId(ONESIGNAL_APP_ID);

        OneSignal.promptForPushNotifications();
    }
}