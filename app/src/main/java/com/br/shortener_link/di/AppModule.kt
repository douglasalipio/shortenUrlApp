package com.br.shortener_link.di

import com.br.shortener_link.core.NetworkService
import com.br.shortener_link.data.shortUrl.datasource.ShortRemoteDataSource
import com.br.shortener_link.data.shortUrl.datasource.ShortRemoteDataSourceImpl
import com.br.shortener_link.data.shortUrl.repository.ShortRepositoryImpl
import com.br.shortener_link.domain.shortUrl.repository.ShortRepository
import org.koin.dsl.module

object AppModule {

    val dataModule = module {
        single { NetworkService.create() }
        single<ShortRemoteDataSource> { ShortRemoteDataSourceImpl(get()) }
        single<ShortRepository> { ShortRepositoryImpl(get()) }
    }

    val domainModule = module {
//        factory { FetchGamesUseCase(get()) }
//        factory { SaveInvalidateCacheUseCase(get()) }
    }

    val presentationModule = module {
//        viewModel { FetchGamesViewModel(get(), get()) }
    }
}