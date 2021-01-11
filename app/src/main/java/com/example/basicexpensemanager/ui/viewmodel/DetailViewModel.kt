package com.example.basicexpensemanager.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.basicexpensemanager.repositories.DetailRepo
import com.example.basicexpensemanager.data.Expense
import kotlinx.coroutines.launch

class DetailViewModel(application: Application):AndroidViewModel(application) {
        val repo: DetailRepo =
            DetailRepo(application)

        fun insertExpDetail(exp: Expense){
            viewModelScope.launch {
                repo.insertExpense(exp) }
        }

        fun updateExpense(exp:Expense){
            viewModelScope.launch {
                repo.updExpense(exp)
            }

        }

}