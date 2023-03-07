package com.br.shortener_link.di

import com.br.shortener_link.core.NetworkService
import com.br.shortener_link.feature.shortUrl.data.datasource.ShortRemoteDataSource
import com.br.shortener_link.feature.shortUrl.data.datasource.ShortRemoteDataSourceImpl
import com.br.shortener_link.feature.shortUrl.data.repository.ShortRepositoryImpl
import com.br.shortener_link.feature.shortUrl.domain.repository.ShortRepository
import com.br.shortener_link.feature.shortUrl.domain.usecase.SaveUrlUseCase
import com.br.shortener_link.feature.shortUrl.presentation.view.viewmodel.ShortUrlViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object AppModule {

    val dataModule = module {
        single { NetworkService.create() }
        single<ShortRemoteDataSource> { ShortRemoteDataSourceImpl(get()) }
        single<ShortRepository> { ShortRepositoryImpl(get()) }
    }

    val domainModule = module {
        factory { SaveUrlUseCase(get()) }
    }

    val presentationModule = module {
        viewModel { ShortUrlViewModel(get()) }
    }
}