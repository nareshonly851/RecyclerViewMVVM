package com.recyclerviewmvvm

import retrofit2.Response
import java.io.IOException

abstract class SafeApiRequest {
    suspend fun <T : Any> apiRequest(call: suspend () -> Response<T>): T {


        val res = call.invoke()
        if (res.isSuccessful) {
            return res.body()!!
        } else {
            throw ApiException(res.code().toString())
        }

    }
}

class ApiException(message: String) : IOException(message)