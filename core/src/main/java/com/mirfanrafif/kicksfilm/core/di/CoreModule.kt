package com.mirfanrafif.kicksfilm.core.di

import androidx.room.Room
import com.mirfanrafif.kicksfilm.core.data.MovieRepository
import com.mirfanrafif.kicksfilm.core.data.source.remote.RemoteDataSource
import com.mirfanrafif.kicksfilm.core.data.source.remote.api.MovieApiService
import com.mirfanrafif.kicksfilm.core.domain.repository.IMovieRepository
import com.mirfanrafif.kicksfilm.core.utils.AppExecutor
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import okhttp3.CertificatePinner
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val databaseModule = module {
    factory { get<com.mirfanrafif.kicksfilm.core.data.source.local.database.KicksFilmDB>().movieDao() }
    single {
        val passphrase: ByteArray = SQLiteDatabase.getBytes("dicoding".toCharArray())
        val factory = SupportFactory(passphrase)
        Room.databaseBuilder(androidContext(),
            com.mirfanrafif.kicksfilm.core.data.source.local.database.KicksFilmDB::class.java, "kicksfilm.db")
            .fallbackToDestructiveMigration()
            .openHelperFactory(factory)
            .build()
    }
}

val networkModule = module {
    single {
        val hostname =  "api.themoviedb.org"
        val certificatePinner = CertificatePinner.Builder()
            .add(hostname, "sha256/+vqZVAzTqUP8BGkfl88yU7SQ3C8J2uNEa55B7RZjEg0=")
            .build()
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .certificatePinner(certificatePinner)
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()

        retrofit.create(MovieApiService::class.java)
    }
}

val repositoryModule = module {
    single { com.mirfanrafif.kicksfilm.core.data.source.local.LocalDataSource(get()) }
    single { RemoteDataSource(get()) }
    single { AppExecutor() }
    single<IMovieRepository> { MovieRepository(get(), get(), get()) }
}