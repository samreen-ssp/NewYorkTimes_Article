package helper.kotlin.android.com.newyorktimesarticles.api;

import helper.kotlin.android.com.newyorktimesarticles.Utils.Constants.Companion.BASE_URL
import okhttp3.Interceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import okhttp3.Response
import java.io.IOException
import java.util.concurrent.TimeUnit

object NetworkClient {

    private var retrofit: Retrofit? = null

    var client = OkHttpClient.Builder().readTimeout(180, TimeUnit.SECONDS)
            .connectTimeout(180, TimeUnit.SECONDS).addInterceptor(object : Interceptor {
        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): Response {
            val newRequest = chain.request().newBuilder()
                    .addHeader("Authorization", "bearer " )
                    .build()
            return chain.proceed(newRequest)
        }
    }).build()
    //Defining the Retrofit using Builder
    val retrofitClient: Retrofit?
        get() {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .client(client)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
            }
            return retrofit
        }
}
