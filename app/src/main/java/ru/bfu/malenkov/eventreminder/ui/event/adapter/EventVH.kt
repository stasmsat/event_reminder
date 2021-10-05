package ru.bfu.malenkov.eventreminder.ui.event.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import ru.bfu.malenkov.eventreminder.databinding.ItemEventReminderVhBinding
import ru.bfu.malenkov.eventreminder.model.EventReminder
import java.text.SimpleDateFormat
import java.util.*

internal class EventVH(private val binding: ItemEventReminderVhBinding) : RecyclerView.ViewHolder(binding.root) {

    private val simpleDateFormat = SimpleDateFormat("dd MMMM yyyy hh:mm", Locale.getDefault())

    fun bind(eventReminder: EventReminder) {
        binding.apply {
            itemEventReminderDesc.visibility = if (eventReminder.desc.isBlank()) View.GONE else View.VISIBLE

            itemEventReminderTitle.text = eventReminder.title
            itemEventReminderDesc.text = eventReminder.desc
            itemEventReminderDate.text = simpleDateFormat.format(eventReminder.dateStart)
        }
    }
}