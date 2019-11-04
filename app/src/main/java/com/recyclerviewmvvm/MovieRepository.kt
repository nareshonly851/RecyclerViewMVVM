package com.recyclerviewmvvm

class MovieRepository(private val api: MovieApi) : SafeApiRequest() {

    suspend fun getData() = apiRequest { api.GetMoview() }
}