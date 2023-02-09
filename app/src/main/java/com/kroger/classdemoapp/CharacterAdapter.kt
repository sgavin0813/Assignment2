//Submitted By : Gavin Singh
package com.kroger.classdemoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
//list of characters is passed to CharacterAdapter class.
class CharacterAdapter(private val characters: List<Character>) : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CharacterViewHolder(
        //LayoutInflater is a class in Android that is used to instantiate layout XML files into View objects
        //inflate ->xml into view objects so that it can be displayed
        //inflate() is used to inflate "character_card_view" or
        // create its view object to be displayed
        LayoutInflater.from(parent.context)
            .inflate(R.layout.character_card_view, parent, false)
    )

    override fun getItemCount() = characters.size

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = characters[position]
        holder.characterImage.setImageResource(character.image)
        holder.characterName.text = character.name
        holder.characterAge.text = character.number
    }
    //here, viewHolder is created
    //viewHolder -> as name suggest holds our views e.g. -> the the whole screen
    //itemView ->   individual item e.g., in our contact app each contact is itemView
    class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val characterImage: ImageView = itemView.findViewById(R.id.character_image)
        val characterName: TextView = itemView.findViewById(R.id.character_name)
        val characterAge: TextView = itemView.findViewById(R.id.character_age)
    }
}
