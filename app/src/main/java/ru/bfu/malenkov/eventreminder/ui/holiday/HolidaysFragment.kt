package ru.bfu.malenkov.eventreminder.ui.holiday

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.bfu.malenkov.eventreminder.data.repository.HolidayRepositoryNet
import ru.bfu.malenkov.eventreminder.databinding.FragmentHolidaysBinding
import ru.bfu.malenkov.eventreminder.ui.holiday.adapter.HolidayVM
import ru.bfu.malenkov.eventreminder.ui.holiday.adapter.HolidaysAdapter

class HolidaysFragment : Fragment() {

    private var _binding: FragmentHolidaysBinding? = null
    private val binding get() = _binding!!
    private val holidaysAdapter = HolidaysAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentHolidaysBinding.inflate(inflater, container, false).apply {
            holidaysRecyclerview.adapter = holidaysAdapter
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val holidayRepositoryNet = HolidayRepositoryNet()
        CoroutineScope(Dispatchers.Main).launch {
            val result = holidayRepositoryNet.holidayList(2019)
            val holidayVMList = result.map { HolidayVM(it) {} }
            holidaysAdapter.reload(holidayVMList)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}