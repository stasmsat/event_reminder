package ru.bfu.malenkov.eventreminder.domain.repository

import ru.bfu.malenkov.eventreminder.domain.model.EventReminder

interface EventReminderRepository {

    suspend fun getEventReminderList(): List<EventReminder>
}