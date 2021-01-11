package com.example.basicexpensemanager.ui.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.basicexpensemanager.data.Expense
import com.example.basicexpensemanager.R

class ExpenseAdapter(val expenses: List<Expense>, val listener: OnItemClickListener): RecyclerView.Adapter<ExpenseAdapter.ExpenseViewHolder>() {

    inner class ExpenseViewHolder(view: View):RecyclerView.ViewHolder(view),View.OnClickListener{

        val title = view.findViewById<TextView>(R.id.title1)
        val amt = view.findViewById<TextView>(R.id.amt1)
        val date = view.findViewById<TextView>(R.id.date_time)

        init{
            view.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val position = adapterPosition
            if(position!=RecyclerView.NO_POSITION)
                listener.onItemClick(position)
        }

    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ExpenseViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.cardview,parent,false)
        return ExpenseViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return expenses.size
    }

    override fun onBindViewHolder(holder: ExpenseViewHolder, position: Int) {
        val item = expenses[position]
        with(holder){
            title.text = item.titledb
            amt.text = item.amtdb
            date.text = item.datedb
        }

    }

    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }
}