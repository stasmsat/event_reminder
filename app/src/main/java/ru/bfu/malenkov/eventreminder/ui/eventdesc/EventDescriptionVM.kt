package ru.bfu.malenkov.eventreminder.ui.eventdesc

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.bfu.malenkov.eventreminder.domain.model.EventReminder
import ru.bfu.malenkov.eventreminder.ui.common.App

class EventDescriptionVM(application: Application) : AndroidViewModel(application) {

    private var eventReminder: EventReminder? = null
    val titleObs = ObservableField("")

    fun loadData(eventId: Int) {
        viewModelScope.launch {
            eventReminder = getApplication<App>().eventReminderRepository.getEventReminder(eventId)
            eventReminder?.run {
                titleObs.set(title)
            }
        }
    }

    fun removeEvent() {
        viewModelScope.launch {
            eventReminder?.let {
                getApplication<App>().eventReminderRepository.removeEventReminder(it)
            }
            closeView()
        }
    }

    fun editEvent() {
        getApplication<App>().mainRouter.showEventEditScreen(eventReminder?.id ?: -1)
    }

    private fun closeView() {
        getApplication<App>().mainRouter.back()
    }
}