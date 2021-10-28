package com.example.mkx_app.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import com.example.mkx_app.R
import com.example.mkx_app.models.User


class InformationFragment : Fragment() {

    lateinit var editName:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_information, container, false)

        this.editName = view.findViewById<EditText>(R.id.editSigninName)
        this.editName.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                //Toast.makeText(getActivity(), "Before text changed", Toast.LENGTH_SHORT).show()
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                //Toast.makeText(getActivity(), "on text changed", Toast.LENGTH_SHORT).show()
                User.isNumber(editName.text.toString(), getActivity()!!)
            }

            override fun afterTextChanged(s: Editable?) {
                //Toast.makeText(getActivity(), "after text changed", Toast.LENGTH_SHORT).show()

            }

        })
        return view
    }
}