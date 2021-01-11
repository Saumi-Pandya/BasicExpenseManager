package com.example.basicexpensemanager.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.basicexpensemanager.R
import com.example.basicexpensemanager.data.Expense
import com.example.basicexpensemanager.ui.viewmodel.DetailViewModel
import com.example.basicexpensemanager.ui.viewmodel.DisplayViewModel
import java.text.DateFormat
import java.util.*


class UpdateFragment : Fragment() {

    lateinit var viewModel1: DetailViewModel
    lateinit var viewModel2: DisplayViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel1 = ViewModelProvider(this).get(DetailViewModel::class.java)
        viewModel2 = ViewModelProvider(this).get(DisplayViewModel::class.java)
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_update, container, false)
    }



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val id = requireArguments().getLong("id")


        var product: Expense
        viewModel2.getExp().observe(viewLifecycleOwner, Observer {
            product = it.find { it.id==id }!!
            setandUpdate(product)
        })

    }

    fun setandUpdate(product: Expense){
        val title = requireView().findViewById<EditText>(R.id.title_u)
        val amt = requireView().findViewById<EditText>(R.id.amt_u)
        val updbtn = requireView().findViewById<Button>(R.id.updatebtn)

        title.setText(product.titledb.toString())
        amt.setText(product.amtdb.toString())
        var currentdate: Date = Calendar.getInstance().time
        var dateStr: String = DateFormat.getInstance().format(currentdate)

        updbtn.setOnClickListener {
            val exp = Expense(product.id,title.text.toString(),amt.text.toString(),dateStr)
            viewModel1.updateExpense(exp)
            requireActivity().onBackPressed()
        }

    }

}