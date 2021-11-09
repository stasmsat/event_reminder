package ru.bfu.malenkov.eventreminder.data.network.services

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import ru.bfu.malenkov.eventreminder.data.network.model.HolidayResponse

internal interface HolidayServiceApi {

    @GET("holidays")
    suspend fun getHolidays(
        @Query("api_key") key: String,
        @Query("country") country: String,
        @Query("year") year: Int
    ): Response<HolidayResponse>
}