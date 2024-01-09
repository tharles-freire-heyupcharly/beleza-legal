package com.mackenzie.belezalegal

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.wajahatkarim3.easyvalidation.core.Validator
import com.mackenzie.belezalegal.databinding.FragmentQuestion2Binding
import com.mackenzie.belezalegal.FieldsHelper
import com.mackenzie.belezalegal.databinding.FragmentQuestion3Binding
import com.mackenzie.belezalegal.databinding.FragmentQuestion24Binding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class Question24Fragment : Fragment() {
    private val viewModel: SharedViewModel by activityViewModels()
    private var _binding: FragmentQuestion24Binding? = null
    private val fields =  FieldsHelper()
    //private var validator: Validator? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentQuestion24Binding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setFields()

        binding.buttonNext.setOnClickListener {
            if(
                !(binding.answer24.checkedRadioButtonId == -1)
            ){
                findNavController().navigate(R.id.action_question24Fragment_to_question25Fragment)
            } else{
                Toast.makeText(context, "Preencha todos os campos antes de prosseguir!",Toast.LENGTH_SHORT).show()
            }

        }


    }

    override fun onResume() {
        super.onResume()
        //setFields()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setFields(){
        val rb = fields.setRadioOptions(context,binding.answer24,resources.getStringArray(R.array.answer24))
        binding.answer24.setOnCheckedChangeListener { group, checkedId ->
            val rb = group.findViewById<RadioButton>(checkedId)
            val index = group.indexOfChild(rb)
            viewModel.answer24.value = rb.text.toString()
            viewModel.weight24.value = index.toString()
        }
    }
}

