package ru.bfu.malenkov.eventreminder.ui.holiday.adapter

import ru.bfu.malenkov.eventreminder.domain.model.Holiday

data class HolidayVM(
    val data: Holiday,
    val onClick: () -> Unit
) {
    fun title() = data.name

    fun desc() = data.description
}