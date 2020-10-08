package com.appcent.aircent.ui.airlines

import androidx.recyclerview.widget.RecyclerView
import com.appcent.aircent.data.remote.response.Airline
import com.appcent.aircent.databinding.AirlineItemBinding

class AirlineViewHolder(
    val binding: AirlineItemBinding
): RecyclerView.ViewHolder(binding.root){


    fun bind(airline: Airline){
        if(airline == null){
            val resources = itemView.resources
            binding.apply {
                destinationName.text = "Loading"
                destinationAbbr.text = "N/A"
            }
        }
        else{
            binding.apply {
                destinationName.text = airline.publicName
                destinationAbbr.text = airline.iata ?: "N/A"
            }
        }

    }
}