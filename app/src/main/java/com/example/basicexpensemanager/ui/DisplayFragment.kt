package com.example.basicexpensemanager.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.basicexpensemanager.data.Expense
import com.example.basicexpensemanager.R
import com.google.android.material.floatingactionbutton.FloatingActionButton


class DisplayFragment : Fragment(),
    ExpenseAdapter.OnItemClickListener {

    lateinit var viewModel: DisplayViewModel
    lateinit var expenses:List<Expense>
    val floatingBtn = requireView().findViewById<FloatingActionButton>(R.id.floatingActionButton)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

         viewModel = ViewModelProvider(this).get(DisplayViewModel::class.java)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_display, container, false)

    }



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //code to handle FloatingActionButton(move to DetailFragment)
        floatingBtn.setOnClickListener{
            findNavController().navigate(R.id.action_displayFragment_to_detailFragment)
        }

        var expenses:List<Expense>
        viewModel.expenses.observe(viewLifecycleOwner, Observer {
            expenses = it
        })



    }

    override fun onItemClick(position: Int) {

    }


}