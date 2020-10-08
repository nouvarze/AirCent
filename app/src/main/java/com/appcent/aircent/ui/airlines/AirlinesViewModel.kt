package com.appcent.aircent.ui.airlines

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.appcent.aircent.data.remote.response.Airline
import com.appcent.aircent.data.repository.Repository
import kotlinx.coroutines.flow.Flow

class AirlinesViewModel @ViewModelInject constructor(private val repository: Repository) : ViewModel() {

    private var result: Flow<PagingData<Airline>>? = null

    fun getAirlines(): Flow<PagingData<Airline>>{
        if(result == null){
            val newResult: Flow<PagingData<Airline>> = repository.getAirlineResultStream().cachedIn(viewModelScope)
            result = newResult
        }
        return result!!
    }
}