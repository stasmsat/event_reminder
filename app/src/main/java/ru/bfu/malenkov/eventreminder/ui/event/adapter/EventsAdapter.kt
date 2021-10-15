package ru.bfu.malenkov.eventreminder.ui.event.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.bfu.malenkov.eventreminder.databinding.ItemEventReminderVhBinding
import ru.bfu.malenkov.eventreminder.domain.model.EventReminder

internal class EventsAdapter : RecyclerView.Adapter<EventVH>() {

    private val eventReminderList = mutableListOf<EventReminder>()

    fun reload(newData: List<EventReminder>) {
        eventReminderList.clear()
        eventReminderList.addAll(newData)
        notifyItemRangeChanged(0, eventReminderList.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventVH {
        return EventVH(
            ItemEventReminderVhBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: EventVH, position: Int) {
        holder.bind(eventReminderList[position])
    }

    override fun getItemCount(): Int = eventReminderList.size
}