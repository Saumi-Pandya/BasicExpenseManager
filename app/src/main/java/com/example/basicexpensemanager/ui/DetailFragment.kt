package com.example.basicexpensemanager.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import com.example.basicexpensemanager.R
import com.example.basicexpensemanager.data.Expense
import java.text.DateFormat
import java.util.*


class DetailFragment : Fragment() {

    lateinit var viewModel: DetailViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val title = requireView().findViewById<EditText>(R.id.title_u)
        val amt = requireView().findViewById<EditText>(R.id.amt_u)
        val saveBtn = requireView().findViewById<Button>(R.id.updatebtn)
        var currentdate: Date = Calendar.getInstance().time
        var dateStr: String = DateFormat.getInstance().format(currentdate)

        saveBtn.setOnClickListener {

            var expObject: Expense = Expense(0L,title.text.toString(),"Rs "+amt.text.toString(),dateStr)
            viewModel.insertExpDetail(expObject)
            requireActivity().onBackPressed()
        }
    }


}