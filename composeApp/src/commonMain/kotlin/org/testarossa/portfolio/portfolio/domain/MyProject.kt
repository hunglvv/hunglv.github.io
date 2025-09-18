package org.testarossa.portfolio.portfolio.domain

val MY_PROJECTS = listOf(
    MyProject(
        "Fan Noises",
        "fan_description",
        listOf("Kotlin", "MVI", "Jetpack Compose", "Coroutines", "Retrofit", "Dagger Hilt"),
        "files/fan/img_%d.webp",
        7
    ),
    MyProject(
        "Stickman Animation ",
        "stickman_description",
        listOf("Kotlin", "MVI", "Jetpack Compose", "Coroutines", "FFmpeg", "Dagger Hilt"),
        "files/stickman/img_%d.webp",
        5
    ),
    MyProject(
        "Thermal Camera",
        "thermal_description",
        listOf("Kotlin", "MVI", "Jetpack Compose", "Camera", "OpenGL", "Dagger Hilt"),
        "files/thermal/img_%d.webp",
        4
    ),
    MyProject(
        "Prank Sound",
        "prank_description",
        listOf("Kotlin", "MVVM", "Data Binding", "Text to Speech", "Voice Change", "Retrofit"),
        "files/prank/img_%d.webp",
        7
    ),
    MyProject(
        "Charging Animation",
        "charging_description",
        listOf("Kotlin", "MVVM", "Data Binding", "Service", "Lottie", "Retrofit", "Work Manager"),
        "files/charging/img_%d.webp",
        5
    ),
    MyProject(
        "Identify Plant",
        "plant_description",
        listOf("Kotlin", "MVVM", "Data Binding", "Clean Architecture", "Work Manager", "Room"),
        "files/plant/img_%d.webp",
        6
    ),
    MyProject(
        "Compass",
        "compass_description",
        listOf("Kotlin", "MVVM", "Data Binding", "Sensor API", "Map", "Camera"),
        "files/compass/img_%d.webp",
        5
    ),
    MyProject(
        "Time Stamp",
        "stamp_description",
        listOf("Kotlin", "MVVM", "Data Binding", "FFmpeg", "Clean Architecture"),
        "files/stamp/img_%d.webp",
        5
    ),
    MyProject(
        "Magnify",
        "magnify_description",
        listOf("Kotlin", "MVVM", "Data Binding", "Clean Architecture", "Retrofit", "AI"),
        "files/magnify/img_%d.webp",
        4
    ),
    MyProject(
        "Renaissance",
        "renai_description",
        listOf("Kotlin", "MVVM", "Data Binding", "Clean Architecture", "Camera"),
        "files/renai/img_%d.webp",
        4
    ),
)


data class MyProject(
    val title: String,
    val description: String,
    val techs: List<String>,
    val pathImage: String,
    val sizeImage: Int
)

