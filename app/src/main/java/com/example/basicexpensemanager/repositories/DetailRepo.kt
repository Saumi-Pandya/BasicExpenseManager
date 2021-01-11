package com.example.basicexpensemanager.repositories

import android.app.Application
import com.example.basicexpensemanager.data.Expense
import com.example.basicexpensemanager.data.ExpenseDatabase

class DetailRepo(context: Application) {
        val detailRepo = ExpenseDatabase.getDatabase(
            context
        ).detailDao()

       suspend  fun insertExpense(exp: Expense){
           detailRepo.insertExpense(exp)
       }

    suspend fun updExpense(exp: Expense){
        detailRepo.updExp(exp)
    }


}