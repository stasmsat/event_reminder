package ru.bfu.malenkov.eventreminder.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import ru.bfu.malenkov.eventreminder.R
import ru.bfu.malenkov.eventreminder.databinding.ActivityMainBinding
import ru.bfu.malenkov.eventreminder.ui.common.LogLifecycle
import ru.bfu.malenkov.eventreminder.ui.event.EventsFragment
import ru.bfu.malenkov.eventreminder.ui.holiday.HolidaysFragment
import ru.bfu.malenkov.eventreminder.ui.profile.ProfileFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LogLifecycle(lifecycle, "MainActivity")
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        if (savedInstanceState == null) updateMainContent(EventsFragment())

        initNavigation()
    }

    private fun initNavigation() {
        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.bottomMenuEvents  -> updateMainContent(EventsFragment())
                R.id.bottomMenuHoliday -> updateMainContent(HolidaysFragment())
                R.id.bottomMenuProfile -> updateMainContent(ProfileFragment())
                else                   -> false
            }
        }
    }

    private fun updateMainContent(newFragment: Fragment): Boolean {
        val tag = newFragment::class.java.name
        supportFragmentManager.beginTransaction()
            .replace(binding.mainContent.id, newFragment, tag)
            .commit()
        return true
    }
}