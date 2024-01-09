package com.mackenzie.belezalegal


import android.widget.Toast
import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley



class SharedViewModel : ViewModel() {

    val consent1 = MutableLiveData<Boolean>(false)
    val consent2 = MutableLiveData<Boolean>(false)
    val consent3 = MutableLiveData<Boolean>(false)
    val answerEmail = MutableLiveData<String>("")
    val answer1 = MutableLiveData<String>("")
    val answer2 = MutableLiveData<String>("")
    val answer3 = MutableLiveData<String>("")
    val answer4 = MutableLiveData<String>("")
    val answer5 = MutableLiveData<String>("")
    val answer6 = MutableLiveData<String>("")
    val answer7 = MutableLiveData<String>("")
    val answer8 = MutableLiveData<String>("")
    val answer9 = MutableLiveData<String>("")
    val answer10 = MutableLiveData<String>("")
    val answer11 = MutableLiveData<String>("")
    val answer12 = MutableLiveData<String>("")
    val answer13 = MutableLiveData<String>("")
    val answer14 = MutableLiveData<String>("")
    val answer15 = MutableLiveData<String>("")
    val answer16 = MutableLiveData<String>("")
    val answer17 = MutableLiveData<String>("")
    val answer18 = MutableLiveData<String>("")
    val answer19 = MutableLiveData<String>("")
    val answer20 = MutableLiveData<String>("")
    val answer21 = MutableLiveData<String>("")
    val answer22 = MutableLiveData<String>("")
    val answer23 = MutableLiveData<String>("")
    val answer24 = MutableLiveData<String>("")
    val answer25 = MutableLiveData<String>("")
    val answer26 = MutableLiveData<String>("")
    val answer27 = MutableLiveData<String>("")

    val weight1 = MutableLiveData<String>("")
    val weight2 = MutableLiveData<String>("")
    val weight3 = MutableLiveData<String>("")
    val weight4 = MutableLiveData<String>("")
    val weight5 = MutableLiveData<String>("")
    val weight6 = MutableLiveData<String>("")
    val weight7 = MutableLiveData<String>("")
    val weight8 = MutableLiveData<String>("")
    val weight9 = MutableLiveData<String>("")
    val weight10 = MutableLiveData<String>("")
    val weight11 = MutableLiveData<String>("")
    val weight12 = MutableLiveData<String>("")
    val weight13 = MutableLiveData<String>("")
    val weight14 = MutableLiveData<String>("")
    val weight15 = MutableLiveData<String>("")
    val weight16 = MutableLiveData<String>("")
    val weight17 = MutableLiveData<String>("")
    val weight18 = MutableLiveData<String>("")
    val weight19 = MutableLiveData<String>("")
    val weight20 = MutableLiveData<String>("")
    val weight21 = MutableLiveData<String>("")
    val weight22 = MutableLiveData<String>("")
    val weight23 = MutableLiveData<String>("")
    val weight24 = MutableLiveData<String>("")
    val weight25 = MutableLiveData<String>("")
    val weight26 = MutableLiveData<String>("")


    val risk1 = MutableLiveData<String>("")
    val risk2 = MutableLiveData<String>("")
    val risk3 = MutableLiveData<String>("")
    val risk4 = MutableLiveData<String>("")
    val risk5 = MutableLiveData<String>("")
    val risk6 = MutableLiveData<String>("")
    val risk7 = MutableLiveData<String>("")
    val risk8 = MutableLiveData<String>("")
    val risk9 = MutableLiveData<String>("")
    val risk10 = MutableLiveData<String>("")
    val risk11 = MutableLiveData<String>("")
    val risk12 = MutableLiveData<String>("")
    val risk13 = MutableLiveData<String>("")
    val risk14 = MutableLiveData<String>("")
    val risk15 = MutableLiveData<String>("")
    val risk16 = MutableLiveData<String>("")
    val risk17 = MutableLiveData<String>("")
    val risk18 = MutableLiveData<String>("")
    val risk19 = MutableLiveData<String>("")
    val risk20 = MutableLiveData<String>("")
    val risk21 = MutableLiveData<String>("")
    val risk22 = MutableLiveData<String>("")
    val risk23 = MutableLiveData<String>("")
    val risk24 = MutableLiveData<String>("")
    val risk25 = MutableLiveData<String>("")
    val risk26 = MutableLiveData<String>("")
    val risk27 = MutableLiveData<String>("")

    fun saveToSheet(context: Context?){
        val url = "https://script.google.com/macros/s/AKfycbxHQpr9BxFyjzhWA0q4wYtdj8ahDY0i_ZO8MAjGGx6LWpK2oHFLjWwjLsIzkI8EWiRKdg/exec"
        val stringRequest=object : StringRequest(
            Request.Method.POST,url,
            Response.Listener { Toast.makeText(context, it.toString(), Toast.LENGTH_LONG).show()},
            Response.ErrorListener{
                Toast.makeText(context, it.toString(), Toast.LENGTH_LONG).show()
                Log.e("Request Error",it.toString())
            }){
            override fun getParams(): MutableMap<String,String> {
                val params=HashMap<String,String>()
                params["consent1"] = consent1.value.toString()
                params["consent2"] = consent2.value.toString()
                params["consent3"] = consent3.value.toString()
                params["email"] = answerEmail.value.toString()
                params["answer1"] = answer1.value.toString()
                params["answer2"] = answer2.value.toString()
                params["answer3"] = answer3.value.toString()
                params["answer4"] = answer4.value.toString()
                params["answer5"] = answer5.value.toString()
                params["answer6"] = answer6.value.toString()
                params["answer7"] = answer7.value.toString()
                params["answer8"] = answer8.value.toString()
                params["answer9"] = answer9.value.toString()
                params["answer10"] = answer10.value.toString()
                params["answer11"] = answer11.value.toString()
                params["answer12"] = answer12.value.toString()
                params["answer13"] = answer13.value.toString()
                params["answer14"] = answer14.value.toString()
                params["answer15"] = answer15.value.toString()
                params["answer16"] = answer16.value.toString()
                params["answer17"] = answer17.value.toString()
                params["answer18"] = answer18.value.toString()
                params["answer19"] = answer19.value.toString()
                params["answer20"] = answer20.value.toString()
                params["answer21"] = answer21.value.toString()
                params["answer22"] = answer22.value.toString()
                params["answer23"] = answer23.value.toString()
                params["answer24"] = answer24.value.toString()
                params["answer25"] = answer25.value.toString()
                params["answer26"] = answer26.value.toString()


                return params
            }
        }
        val queue= Volley.newRequestQueue(context)
        queue.add(stringRequest)
    }

}


