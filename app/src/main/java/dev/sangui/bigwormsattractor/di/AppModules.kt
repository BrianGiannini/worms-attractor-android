package dev.sangui.bigwormsattractor.di

import dev.sangui.bigwormsattractor.logic.WormVibratorService
import dev.sangui.bigwormsattractor.logic.WormVibratorServiceImpl
import dev.sangui.bigwormsattractor.view.SandWormViewModel
import org.koin.dsl.module

val appModule = module {
    single<WormVibratorService> { WormVibratorServiceImpl(get())}
    single { SandWormViewModel(get()) }
}