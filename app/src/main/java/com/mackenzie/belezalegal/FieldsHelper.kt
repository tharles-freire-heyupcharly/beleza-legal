package com.mackenzie.belezalegal

import android.content.Context
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup

public class FieldsHelper {


    fun setRadioOptions(context: Context?, rg: RadioGroup, options: Array<String>){
        val params = RadioGroup.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        params.setMargins(0,16,0,0)

        for(item in options){
            val radioButton = RadioButton(context)
            radioButton.layoutParams = LinearLayout.LayoutParams(params)
            radioButton.setPadding(16,16,16,16)

            radioButton.setText(item.toString())
            rg.addView(radioButton)
        }

    }

}