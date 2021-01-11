package com.example.basicexpensemanager.data

import androidx.room.*

@Dao
interface DetailDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
   suspend fun insertExpense(exp: Expense)

    @Update
    suspend fun updExp(exp:Expense)

}