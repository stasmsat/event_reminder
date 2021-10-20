package ru.bfu.malenkov.eventreminder.ui.eventedit

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.bfu.malenkov.eventreminder.domain.model.EventReminder
import ru.bfu.malenkov.eventreminder.ui.common.App

class EventEditVM(application: Application) : AndroidViewModel(application) {

    val titleObs = object : ObservableField<String>() {
        override fun set(value: String?) {
            super.set(value)
            eventReminder = eventReminder.copy(title = value!!)
        }
    }

    val descObs = object : ObservableField<String>() {
        override fun set(value: String?) {
            super.set(value)
            eventReminder = eventReminder.copy(desc = value!!)
        }
    }
    private val dateStringObs = ObservableField("")
    private lateinit var eventReminder: EventReminder

    fun loadData(eventId: Int) {
        viewModelScope.launch {
            val event = getApplication<App>().eventReminderRepository.getEventReminder(eventId)
            eventReminder = event ?: EventReminder.emptyEventReminder()
            eventReminder.run {
                titleObs.set(title)
                descObs.set(desc)
            }
        }
    }

    fun saveData() {
        viewModelScope.launch {
            getApplication<App>().eventReminderRepository.saveEventReminder(eventReminder)
            closeView()
        }
    }

    private fun closeView() {
        getApplication<App>().mainRouter.back()
    }
}