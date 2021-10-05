package ru.bfu.malenkov.eventreminder.model

import java.util.*

data class EventReminder(
    val title: String,
    val desc: String,
    val dateStart: Date
)