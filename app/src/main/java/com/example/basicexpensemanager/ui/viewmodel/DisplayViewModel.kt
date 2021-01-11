package com.example.basicexpensemanager.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.basicexpensemanager.repositories.DisplayRepo
import com.example.basicexpensemanager.data.Expense
import kotlinx.coroutines.launch

class DisplayViewModel(application: Application): AndroidViewModel(application) {

    private val repo =
        DisplayRepo(application)

    //private var _expenses = MutableLiveData<List<Expense>>()

   private  val expenses : LiveData<List<Expense>> = repo.getExpenseList()

    fun getExp():LiveData<List<Expense>>{
        return expenses
    }

    fun deleteExpense(exp: Expense){
        viewModelScope.launch {
            repo.deleteExp(exp)
        }

    }






}