package ru.bfu.malenkov.eventreminder.ui.event

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.bfu.malenkov.eventreminder.data.db.AppDatabase
import ru.bfu.malenkov.eventreminder.data.repository.EventReminderRepositoryDb
import ru.bfu.malenkov.eventreminder.domain.model.EventReminder
import java.time.LocalDate

class EventsViewModel(application: Application) : AndroidViewModel(application) {

    private val eventsReminder: MutableLiveData<List<EventReminder>> = MutableLiveData()
    private val eventReminderRepository = EventReminderRepositoryDb(
        database = AppDatabase.getInstance(getApplication())
    )

    init {
        loadEventsReminder()
    }

    fun getEvents(): LiveData<List<EventReminder>> {
        return eventsReminder
    }

    private fun loadEventsReminder() {
        viewModelScope.launch {
            eventsReminder.value = eventReminderRepository.getEventReminderList()
        }

    }
}