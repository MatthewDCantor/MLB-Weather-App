package com.example.weatherapp

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley


class FirstFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val editText = view.findViewById<EditText>(R.id.editTextZipCode)
        val errorMessage = "Please enter a valid zip code."


        view.findViewById<Button>(R.id.check_weather).setOnClickListener {
            // Use try so that if the user inputs a non int (dlkfjld, 5664.0, ect.) then
            // we output a message in the catch.
            try {

                val zip = editText.text.toString().toInt() // Test if user input an int.
                val url = "https://api.openweathermap.org/data/2.5/weather?zip=${zip},us&appid=addb854c6b1c841e01c428436cf00ae0"
                val queue = Volley.newRequestQueue(requireContext())


                val jsonObjectRequest = JsonObjectRequest(Request.Method.GET, url, null,
                        { response ->

                            val temp = response.optJSONObject("main").get("temp").toString()
                            val city = response.get("name").toString()
                            val data = arrayOf(temp, city)
                            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(data)

                            findNavController().navigate(action)

                        },

                        {
                            editText.text.clear()
                            editText.hint = errorMessage
                        }
                )

                // Access the RequestQueue through your singleton class
                queue.add(jsonObjectRequest)



            }
            catch (e: NumberFormatException){
                editText.text.clear()
                editText.hint = errorMessage
            }




        }



    }
}


