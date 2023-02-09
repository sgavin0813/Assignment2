//Submitted By : Gavin Singh
package com.kroger.classdemoapp


import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    //this is array of random names, our contacts name will be random
    private val nameList = arrayOf("Gavin", "Petra", "Madison", "Aarti", "Peter", "Patrick",
        "Joy", "Eric", "Jose", "Xavier","Axel Lynch" ,"Sahil", "Bradly",
        "Damien", "Ramon", "Shelby" ,
        "Talia", "Ayla" ,"Kegan" ,"Tomas" ,"Simar")
    //we will use this variable to instantiate our text area for name
    private lateinit var randomName:String
    //this is array of random number which would be used as phone number for contacts
    private val numberList = arrayOf("75246936032", "80361845275", "17290596908", "22933969168",
             "79680226914", "94638658094", "58843698122", "79673375248", "68795611458", "32796549405", "64080596427", "23006638254")
    //we will use this variable to instantiate our text area for phone mumber
    private lateinit var randomPhoneNumber:String
    //path to all images are saved here
    private var arrayImage:Array<Int> = arrayOf(R.drawable.two,R.drawable.four,R.drawable.five,R.drawable.six, R.drawable.three,R.drawable.one)
    //this variable will instantiate our image view for each itemView
    private  var randomImage:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.character_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

       // arrayImage = arrayOf(R.drawable.two, R.drawable.three, R.drawable.four, R.drawable.five, R.drawable.six)

        val characters = mutableListOf<Character>()

        for (i in 0..30) {
            //a random name is selected from array
            randomName = nameList[Random.nextInt(nameList.size)]
            //a random phone number is selected from our array
            randomPhoneNumber = numberList[Random.nextInt(numberList.size)]
            // an image is randomly selected form given images and saved here
            randomImage = arrayImage[Random.nextInt(arrayImage.size)]
            //function to add values to our list
            characters.add(createCharacter())
        }
        //we can have more than 1 Adapter class
        //this statement associate adapter with CharacterAdapter
        val adapter = CharacterAdapter(characters)
        recyclerView.adapter = adapter
    }

    private fun createCharacter() = Character(
        // random value for name, phone number and image are placed in views inside given itemView
        name = randomName,
        number = randomPhoneNumber ,
        image = randomImage,
        relation = listOf()
    )
}
