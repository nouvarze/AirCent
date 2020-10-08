package com.appcent.aircent.ui.airlines

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.appcent.aircent.R
import com.appcent.aircent.data.remote.response.Airline
import com.appcent.aircent.databinding.AirlineItemBinding

class AirlinesListAdapter: PagingDataAdapter<Airline, AirlineViewHolder>(AIRLINE_COMPARATOR) {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AirlineViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding:AirlineItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.airline_item,
            parent,
            false
        )
        return AirlineViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AirlineViewHolder, position: Int) {
        val airlineItem = getItem(position)
        if(airlineItem != null) holder.bind(airlineItem)
    }



    companion object{
        private val AIRLINE_COMPARATOR = object: DiffUtil.ItemCallback<Airline>(){
            override fun areItemsTheSame(oldItem: Airline, newItem: Airline): Boolean {
                return oldItem.iata == newItem.iata
            }

            override fun areContentsTheSame(oldItem: Airline, newItem: Airline): Boolean {
                return oldItem.iata == newItem.iata
            }
        }
    }
}

