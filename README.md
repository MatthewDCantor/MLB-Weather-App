# MLB Weather App
A sample weather application that shows the weather in a certain city by providing the zip code. This app was built using kotlin in android studio. 

API used in retrieving weather data: https://openweathermap.org/api

Screen One
First screen includes a centered input box and button. The input allows the user to input a zip code and a button that allows them to look up the weather
The button transitions the user to the second screen

Screen Two
Displays the current city name that was looked up by zip code
Displays the current weather conditions in both Fahrenheit and Celsius

The app includes unit tests to check that the transformation from kelvin to celsius and fahrenheit. 
If an invalid zip code is entered, the text is cleared and the user is informed that the zip code was invalid. 
