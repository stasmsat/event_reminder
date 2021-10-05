package ru.bfu.malenkov.eventreminder.ui.event

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.bfu.malenkov.eventreminder.model.EventReminder
import java.util.*

class EventsViewModel : ViewModel() {

    private val eventsReminder: MutableLiveData<List<EventReminder>> = MutableLiveData()

    init {
        loadEventsReminder()
    }

    fun getEvents(): LiveData<List<EventReminder>> {
        return eventsReminder
    }

    private fun loadEventsReminder() {
        val list = listOf(
            EventReminder("День рождение Андрея", "Нужно поздравить с утра", Date()),
            EventReminder("День рождение Виктора", "Длинное описание. Ооооочень длииннное описание события. Ну оооооочень длинное описание ", Date()),
            EventReminder("День группы", "", Date()),
        )
        eventsReminder.postValue(list)
    }
}