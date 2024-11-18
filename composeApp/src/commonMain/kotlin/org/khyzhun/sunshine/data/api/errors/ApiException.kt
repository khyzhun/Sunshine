package org.khyzhun.sunshine.data.api.errors

class ApiException(
    val statusCode: Int,
    val errorBody: String? = null
) : Exception("API Error: $statusCode - $errorBody")