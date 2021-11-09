package ru.bfu.malenkov.eventreminder.data.network.services

import retrofit2.Response
import ru.bfu.malenkov.eventreminder.data.network.model.HolidayResponse

internal class HolidayService(
    private val apiService: HolidayServiceApi
) {
    private val apiKey = "8d6f01dced1e3c4f4a2f34bed44862963dc373dc"

    suspend fun getHolidays(country: String, year: Int): Response<HolidayResponse> =
        apiService.getHolidays(
            key = apiKey,
            year = year,
            country = country
        )
}