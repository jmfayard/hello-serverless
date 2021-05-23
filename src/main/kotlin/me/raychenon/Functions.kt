package me.raychenon


import io.kotless.dsl.lang.http.Get

@Get("/hello")
fun sayHello() = "Say Hello!"

@Get("/weather")
fun fetchWeather() = "Weather is good!"
