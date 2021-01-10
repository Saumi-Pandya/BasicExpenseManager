package com.example.basicexpensemanager.ui

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.basicexpensemanager.data.Expense
import com.example.basicexpensemanager.R
import com.google.android.material.floatingactionbutton.FloatingActionButton


class DisplayFragment : Fragment(),
    ExpenseAdapter.OnItemClickListener {

    lateinit var viewModel: DisplayViewModel


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

   // lateinit var expenses:List<Expense>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getExp().observe(viewLifecycleOwner, Observer {
            setRecyclerView(it)
        })
    }



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //code to handle FloatingActionButton(move to DetailFragment)
        val floatingBtn = requireView().findViewById<FloatingActionButton>(R.id.floatingActionButton)
        floatingBtn.setOnClickListener{
            findNavController().navigate(R.id.action_displayFragment_to_detailFragment)
        }
    }

    //code to set the RecyclerView
    fun setRecyclerView(expList: List<Expense>){
        val recyclerView = requireView().findViewById<RecyclerView>(R.id.recy_view)
        val newAdapter = ExpenseAdapter(expList,this@DisplayFragment)
        recyclerView.adapter = newAdapter
        recyclerView.layoutManager = LinearLayoutManager(activity)
    }

    override fun onItemClick(position: Int) {
        val builder = AlertDialog.Builder(requireContext())
        builder.setMessage("What would you like to do?")
        var itemList: List<Expense>? = null
        viewModel.getExp().observe(viewLifecycleOwner, Observer {
                itemList=it})

        val item = itemList!![position]
        builder.setNegativeButton("Delete"){dialogInterface, which ->
              viewModel.deleteExpense(item)
        }

        builder.setPositiveButton("Update"){dialogInterface, which ->
            //viewModel.deleteExpense(item)
        }

        val alertDialog: AlertDialog = builder.create()
        alertDialog.setCancelable(false)
        alertDialog.show()

    }

}