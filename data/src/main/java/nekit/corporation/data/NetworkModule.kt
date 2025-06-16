package nekit.corporation.data

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.Reusable
import kotlinx.serialization.json.Json
import nekit.corporation.yurtify.data.api.ApiAuth
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
@Module
class NetworkModule {
    @UnAuthorize
    @Provides
    @Reusable
    fun provideOkHttpClient(
    ): OkHttpClient = OkHttpClient.Builder()
        .readTimeout(15, TimeUnit.SECONDS)
        .connectTimeout(15, TimeUnit.SECONDS)
        .build()

    @Provides
    @Reusable
    @Authorize
    fun authorizeProvideOkHttpClient(
        interceptor: Interceptor
    ): OkHttpClient = OkHttpClient.Builder()
        .readTimeout(15, TimeUnit.SECONDS)
        .connectTimeout(15, TimeUnit.SECONDS)
        .addInterceptor(interceptor)
        .build()

    @UnAuthorize
    @Provides
    @Reusable
    fun provideRetrofit(@UnAuthorize okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl("http://77.110.105.134:8080/")
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .client(okHttpClient)
        .build()

    @Authorize
    @Provides
    @Reusable
    fun provideAuthorizeRetrofit(@Authorize okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl("http://77.110.105.134:8080/")
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .client(okHttpClient)
            .build()

    @UnAuthorize
    @Provides
    @Reusable
    fun provideAuthService(@UnAuthorize retrofit: Retrofit):
            ApiAuth =
        retrofit.create(ApiAuth::class.java)

    @Reusable
    @Provides
    fun provideAuthorizeAuthService(@Authorize retrofit: Retrofit):
            ApiAuth =
        retrofit.create(ApiAuth::class.java)

}