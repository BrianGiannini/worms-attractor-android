package dev.sangui.bigwormsattractor

import android.app.Application
import dev.sangui.bigwormsattractor.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class WormApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@WormApplication)
            modules(appModule)
        }
    }
}