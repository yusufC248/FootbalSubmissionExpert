package com.yusuf.core.di

import androidx.room.Room
import com.yusuf.core.data.FootballRepository
import com.yusuf.core.data.local.FootballDatabase
import com.yusuf.core.data.local.LocalDataSource
import com.yusuf.core.data.remote.RemoteDataSource
import com.yusuf.core.data.remote.network.ApiService
import com.yusuf.core.domain.IFootballRepository
import com.yusuf.core.utils.AppExecutors
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val databaseModule = module {
    factory { get<FootballDatabase>().footballDao() }
    single {
        Room.databaseBuilder(
            androidContext(),
                FootballDatabase::class.java, "Football.db"
        ).fallbackToDestructiveMigration().build()
    }
}

val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.thesportsdb.com/api/v1/json/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}

val repositoryModule = module {
    single { LocalDataSource(get()) }
    single { RemoteDataSource(get()) }
    factory { AppExecutors() }
    single<IFootballRepository> { FootballRepository(
            get(),
            get(),
            get()
        )
    }
}