package com.example.basicexpensemanager.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Expense::class], version = 1)
abstract class ExpenseDatabase: RoomDatabase() {
    abstract fun displayDao(): DisplayDao
    abstract  fun detailDao(): DetailDao


    companion object{
        @Volatile
        private var instance: ExpenseDatabase? = null

        fun getDatabase(context: Context) = instance
            ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    ExpenseDatabase::class.java,
                    "expense_database"
                ).build().also { instance = it }
            }
    }

}