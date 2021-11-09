package ru.bfu.malenkov.eventreminder.data.network

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.bfu.malenkov.eventreminder.data.network.services.HolidayService
import ru.bfu.malenkov.eventreminder.data.network.services.HolidayServiceApi

internal object AppNetwork {

    private val gson = GsonBuilder()
        .create()

    private val okHttpClient= OkHttpClient().newBuilder()
        .build()

    private val retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl("https://calendarific.com/api/v2/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    val holidayService by lazy {
        val holidayServiceApi = retrofit.create(HolidayServiceApi::class.java)
        HolidayService(holidayServiceApi)
    }
}