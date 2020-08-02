package com.shalom.marvelogy.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.shalom.marvelogy.BuildConfig
import com.shalom.marvelogy.utils.generateMD5Hash
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun getOkHttpClient(): OkHttpClient {
//        val okHttp = OkHttpClient()
//        val interceptor = Interceptor { chain ->
//            val time = System.currentTimeMillis().toString()
//            chain.run {
//                proceed(
//                    request()
//                        .newBuilder()
//                        .addHeader("ts", time)
//                        .addHeader("apikey", BuildConfig.marvelPublic)
//                        .addHeader(
//                            "hash",
//                            "$time${BuildConfig.marvelPrivate}${BuildConfig.marvelPublic}".generateMD5Hash()
//                        )
//                        .build()
//                )
//            }
//        }
//        okHttp.interceptors().add(interceptor)
//        return okHttp
        return OkHttpClient.Builder()
            .addInterceptor { chain ->
                val original: Request = chain.request()
                val time = System.currentTimeMillis().toString()

                // Request customization: add request headers

                val url: HttpUrl = original.url()
                    .newBuilder()
                    .addQueryParameter("ts", time)
                    .addQueryParameter("apikey", BuildConfig.marvelPublic)
                    .addQueryParameter(
                        "hash",
                        "$time${BuildConfig.marvelPrivate}${BuildConfig.marvelPublic}".generateMD5Hash()
                    )
                    .build()
                val requestBuilder: Request.Builder = original.newBuilder().url(url)


                val request: Request = requestBuilder.build()
                chain.proceed(request)
            }
            .build()

    }


    @Singleton
    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson, client: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl("https://gateway.marvel.com/v1/public/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(client)
        .build()
}