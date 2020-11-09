package com.example.weatherapp


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import java.math.BigDecimal
import java.math.RoundingMode


/**
 * This fragment receives the data from the weather API, converts the temperature from kelvin to
 * Fahrenheit and Celsius, and displays the city name and the converted temps.
 */
class ConverterUtil{
    fun kelvinToC(temp:Double): BigDecimal {
        //Convert the temp Celsius and then round to 2 decimals.
        return BigDecimal(temp - 273.15).setScale(2, RoundingMode.HALF_EVEN)
    }

    fun kelvinToF(temp: Double): BigDecimal {
        return BigDecimal(temp*(9.0/5.0) - 459.67).setScale(2, RoundingMode.HALF_EVEN)
    }
}


class SecondFragment : Fragment() {

    // import the args passed from the first fragment
    private val args: SecondFragmentArgs by navArgs()



    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        view.findViewById<Button>(R.id.button_second).setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }

        // initialize the textview vals and retrieve the data from the API call.
        // Finally, the temps are converted.
        val viewTextC = view.findViewById<TextView>(R.id.TextViewTempC)
        val viewTextCity = view.findViewById<TextView>(R.id.TextViewCityName)
        val viewTextF = view.findViewById<TextView>(R.id.TextViewTempF)
        val temp = args.data[0].toDouble()
        val city = args.data[1]
        val util = ConverterUtil()
        val tempC = util.kelvinToC(temp).toString()
        val tempF = util.kelvinToF(temp).toString()

        // display the temps and the city name.
        viewTextC.text = getString(R.string.Temp_C, tempC)
        viewTextCity.text = getString(R.string.City_name, city)
        viewTextF.text = getString(R.string.Temp_F, tempF)

    }
}