package com.example.basicexpensemanager.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query


@Dao
interface DisplayDao {
    @Query("SELECT * from expense")
     fun getExpenseList():LiveData<List<Expense>>

    @Delete
    suspend  fun deleteAnExpense(exp:Expense)
}