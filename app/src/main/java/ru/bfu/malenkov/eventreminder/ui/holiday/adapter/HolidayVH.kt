package ru.bfu.malenkov.eventreminder.ui.holiday.adapter

import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView
import ru.bfu.malenkov.eventreminder.databinding.ItemHolidayVhBinding

internal class HolidayVH(private val binding: ItemHolidayVhBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(holidayVM: HolidayVM) {
        binding.apply {
            setVariable(BR.viewModel, holidayVM)
        }
    }
}