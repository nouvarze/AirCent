package com.appcent.aircent.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.appcent.aircent.data.remote.airlines.AirlineService
import com.appcent.aircent.data.remote.response.Airline
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(val airlineService: AirlineService) {
    fun getAirlineResultStream(): Flow<PagingData<Airline>>{
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {AirlinePagingSource(airlineService)}
        ).flow
    }
}

//interface Repository{
//    fun getAirlineResultStream(): Flow<PagingData<Airline>>
//}