package com.mackenzie.belezalegal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.mackenzie.belezalegal.databinding.FragmentConsentBinding
import com.wajahatkarim3.easyvalidation.core.Validator
import com.wajahatkarim3.easyvalidation.core.view_ktx.nonEmpty
import com.wajahatkarim3.easyvalidation.core.view_ktx.validator


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class ConsentFragment : Fragment() {
    private val viewModel: SharedViewModel by activityViewModels()
    private var _binding: FragmentConsentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentConsentBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonTerms.setOnClickListener {
            findNavController().navigate(R.id.action_consentFragment_to_termFragment)
        }

        binding.buttonNext.setOnClickListener {
            viewModel.answerEmail.value = binding.answerEmail.text.toString()
            if(
                binding.consent1.isChecked &&
                binding.consent2.isChecked &&
                binding.consent3.isChecked &&
                binding.answerEmail.nonEmpty()

                ) {
                viewModel.consent1.value = binding.consent1.isChecked
                viewModel.consent2.value = binding.consent2.isChecked
                viewModel.consent3.value = binding.consent3.isChecked
                viewModel.answerEmail.value = binding.answerEmail.text.toString()

                findNavController().navigate(R.id.action_consentFragment_to_question1Fragment)

            }else {
                Toast.makeText(context,R.string.Dissent,Toast.LENGTH_LONG).show()
            }
        }



    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}