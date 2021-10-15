package ru.bfu.malenkov.eventreminder.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.bfu.malenkov.eventreminder.data.db.helpers.TABLE_EVENT_REMINDER
import ru.bfu.malenkov.eventreminder.data.db.model.EventReminderDb

@Dao
interface EventReminderDao {

    @Query("SELECT * FROM $TABLE_EVENT_REMINDER")
    fun getAll(): List<EventReminderDb>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(events: List<EventReminderDb>)
}