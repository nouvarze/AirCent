package com.appcent.aircent.data.repository

import androidx.paging.PagingSource
import com.appcent.aircent.data.remote.airlines.AirlineService
import com.appcent.aircent.data.remote.response.Airline
import com.appcent.aircent.di.NetworkModule
import dagger.hilt.android.AndroidEntryPoint
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AirlinePagingSource @Inject constructor( val backend: AirlineService) : PagingSource<Int, Airline>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Airline> {
//        backend = NetworkModule.provideAirlineService(NetworkModule.provideRetrofit(NetworkModule.provideOkHttpClient(NetworkModule.provideInterceptor())))
        try {
            val page = params.key ?: 0
            val response = backend.fetchAirlineList(page)

            val prevKey = if (page > 0) page - 1 else null
            val nextKey = if (response.airlines.isNotEmpty()) page + 1 else null

            return LoadResult.Page(
                response.airlines,
                prevKey,
                nextKey
            )
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }

}