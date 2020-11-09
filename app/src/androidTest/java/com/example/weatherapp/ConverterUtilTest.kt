package com.example.weatherapp

import org.junit.Assert
import org.junit.Test
import java.math.BigDecimal
import java.math.RoundingMode

class ConverterUtilTest {
    @Test
    fun checkConversion() {
        val util = ConverterUtil()
        val Fans = BigDecimal(28.72).setScale(2, RoundingMode.HALF_EVEN)
        val Cans = BigDecimal(-1.82).setScale(2, RoundingMode.HALF_EVEN)
        val kelvin = 271.33
        Assert.assertEquals((Fans), util.kelvinToF((kelvin)))
        Assert.assertEquals((Cans),util.kelvinToC(kelvin))

    }
}




