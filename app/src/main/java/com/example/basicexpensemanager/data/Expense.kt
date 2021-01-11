package com.example.basicexpensemanager.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "expense")
data class Expense(@PrimaryKey(autoGenerate = true) val id:Long, var titledb: String, val amtdb: String, val datedb: String)