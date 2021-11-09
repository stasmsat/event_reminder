package ru.bfu.malenkov.eventreminder.ui.holiday.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.bfu.malenkov.eventreminder.databinding.ItemHolidayVhBinding

internal class HolidaysAdapter : RecyclerView.Adapter<HolidayVH>(){
    private val eventReminderList = mutableListOf<HolidayVM>()

    fun reload(newData: List<HolidayVM>) {
        eventReminderList.clear()
        eventReminderList.addAll(newData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolidayVH {
        return HolidayVH(
            ItemHolidayVhBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: HolidayVH, position: Int) {
        holder.bind(eventReminderList[position])
    }

    override fun getItemCount(): Int = eventReminderList.size
}