package ru.bfu.malenkov.eventreminder.data.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.bfu.malenkov.eventreminder.data.db.helpers.TABLE_EVENT_REMINDER
import java.util.*

@Entity(tableName = TABLE_EVENT_REMINDER)
data class EventReminderDb(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo val title: String,
    @ColumnInfo val desc: String?,
    @ColumnInfo val dateStart: Date
)