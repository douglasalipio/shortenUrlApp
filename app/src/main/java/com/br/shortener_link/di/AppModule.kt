package com.br.shortener_link.di

import com.br.shortener_link.core.NetworkService
import org.koin.dsl.module

object AppModule {

    val dataModule = module {
        single { NetworkService.create() }
    }

    val domainModule = module {
//        factory { FetchGamesUseCase(get()) }
//        factory { SaveInvalidateCacheUseCase(get()) }
    }

    val presentationModule = module {
//        viewModel { FetchGamesViewModel(get(), get()) }
    }
}