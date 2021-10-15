package ru.bfu.malenkov.eventreminder.data.repository

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.bfu.malenkov.eventreminder.data.db.AppDatabase
import ru.bfu.malenkov.eventreminder.domain.model.EventReminder
import ru.bfu.malenkov.eventreminder.domain.repository.EventReminderRepository

class EventReminderRepositoryDb(
    private val database: AppDatabase,
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.Default
) : EventReminderRepository {

    override suspend fun getEventReminderList(): List<EventReminder> = withContext(defaultDispatcher) {
        database.eventReminderDao().getAll()
            .map {
                EventReminder(it.title, it.desc ?: "", it.dateStart)
            }
    }
}