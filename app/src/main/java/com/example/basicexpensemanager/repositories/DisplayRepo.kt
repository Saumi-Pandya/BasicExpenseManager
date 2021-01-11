package com.example.basicexpensemanager.repositories

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.basicexpensemanager.data.DisplayDao
import com.example.basicexpensemanager.data.Expense
import com.example.basicexpensemanager.data.ExpenseDatabase

class DisplayRepo(context:Application) {

    private val displayDao: DisplayDao = ExpenseDatabase.getDatabase(
        context
    ).displayDao()

       fun getExpenseList(): LiveData<List<Expense>>{
           return displayDao.getExpenseList()
       }

    suspend fun deleteExp(exp: Expense){
        displayDao.deleteAnExpense(exp)
    }

}