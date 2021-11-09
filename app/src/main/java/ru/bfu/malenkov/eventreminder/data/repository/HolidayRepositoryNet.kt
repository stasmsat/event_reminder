package ru.bfu.malenkov.eventreminder.data.repository

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.bfu.malenkov.eventreminder.data.network.AppNetwork
import ru.bfu.malenkov.eventreminder.domain.model.Holiday

class HolidayRepositoryNet(
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.IO
) {

    private val holidayService = AppNetwork.holidayService

    suspend fun holidayList(year: Int, country: String = "ru"): List<Holiday> = withContext(defaultDispatcher) {
        val response = holidayService.getHolidays(year = year, country = country)
        val holidayList = if (response.isSuccessful) {
            response.body()?.response?.holidays ?: listOf()
        } else listOf()

        holidayList.map {
            with(it) { Holiday(name, description) }
        }
    }
}