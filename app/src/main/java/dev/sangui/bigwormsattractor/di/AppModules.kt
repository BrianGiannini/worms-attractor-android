package dev.sangui.bigwormsattractor.di

import dev.sangui.bigwormsattractor.logic.SoundEffectsImpl
import dev.sangui.bigwormsattractor.logic.SoundEffectsService
import dev.sangui.bigwormsattractor.logic.WormVibratorService
import dev.sangui.bigwormsattractor.logic.WormVibratorServiceImpl
import dev.sangui.bigwormsattractor.view.SandWormViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
    single<WormVibratorService> { WormVibratorServiceImpl(androidContext())}
    single<SoundEffectsService> { SoundEffectsImpl(androidContext())}
    single { SandWormViewModel(get(), get()) }
}