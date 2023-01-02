package com.orlandev.travelapp.data

data class DataResult(
    val result: List<Destination>
) {
    companion object {
        private val activities = listOf<Activities>(

         Activities(
             imageUrl = "https://ik.imagekit.io/6xgh00mrhaz/Cuba_App_Travel_Ui/salmon.jpg",
             name = "Restaurante El Mejor",
             type = "Restaurante",
             startTimes = listOf("7:00 am", "12:00 pm"),
             rating = 5,
             price = 10,
         ),

            Activities(
                imageUrl = "https://ik.imagekit.io/6xgh00mrhaz/Cuba_App_Travel_Ui/bar.jpg",
                name = "Bar la ilusión",
                type = "Bar",
                startTimes = listOf("9:00 am", "10:00 9pm"),
                rating = 5,
                price = 50,
            ),

            Activities(
                imageUrl = "https://ik.imagekit.io/6xgh00mrhaz/Cuba_App_Travel_Ui/bonding.jpg",
                name = "Ruta La central",
                type = "Visitas guiadas",
                startTimes = listOf("8:00 am", "11:00 am"),
                rating = 5,
                price = 20,
            ),

            Activities(
                imageUrl = "https://ik.imagekit.io/6xgh00mrhaz/Cuba_App_Travel_Ui/beach.jpg",
                name = "Hacia la Playa",
                type = "Visitas guiadas",
                startTimes = listOf("8:00 am", "11:00 am"),
                rating = 5,
                price = 100,
            ),


            )

        val mock = listOf<Destination>(

            Destination(
                city = "La Habana",
                country = "Cuba",
                imageUrl = "https://ik.imagekit.io/6xgh00mrhaz/Cuba_App_Travel_Ui/la_habana_IBpl736sH.jpg",
                description = "La Habana es síntesis de toda Cuba, capital de la isla y una de las más hermosas ciudades de Latinoamérica.",
                listOfActivities = activities
            ),
            Destination(
                city = "Santiago de Cuba",
                country = "Cuba",
                imageUrl = "https://ik.imagekit.io/6xgh00mrhaz/Cuba_App_Travel_Ui/santiago.jpg",
                description = "Santiago de Cuba es la capital de la provincia de Santiago de Cuba, en el sureste de Cuba, frente a una bahía del mar Caribe.",
                listOfActivities = activities
            ),
            Destination(
                city = "Trinidad",
                country = "Cuba",
                imageUrl = "https://ik.imagekit.io/6xgh00mrhaz/Cuba_App_Travel_Ui/trinidad.jpg",
                description = "Trinidad es una ciudad del centro de Cuba, conocida por su ciudad antigua colonial y las calles con adoquines. La plaza principal neobarroca, Plaza Mayor, está rodeada de grandes edificios coloniales.",
                listOfActivities = activities
            )


        )
    }
}

data class Destination(
    val imageUrl: String,
    val city: String,
    val country: String,
    val description: String,
    val listOfActivities: List<Activities>
)

data class Activities(
    val imageUrl: String,
    val name: String,
    val type: String,
    val startTimes: List<String>,
    val rating: Int,
    val price: Int
)
