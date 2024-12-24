package com.example.multiviewholder

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ServiceBuilder {

    companion object {
        private var baseUrl = "https://restaurant-api.reciproci.com/"
        private val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

        val headerInterceptor = object : Interceptor {

            override fun intercept(chain: Interceptor.Chain): Response {
                var headers = HashMap<String, String>()
                headers["Content-Type"] = "application/json"
                headers["DEVICE_ID"] = "930cb5749ebcdd68"
                headers["Accept-Language"] = "EN"
                headers["DEVICE_TYPE"] = "Android"
                headers["APP_VERSION"] = "2.1.8.8"
                headers["COUNTRY"] = "India"
                headers["CITY"] = "Noida"
                headers["GUEST_USER_TOKEN"] = "pL7TgrD+zleGbz9Jeazh+irbiuR6t3ypQeJrGxN9uo0="
                headers["DEVICE_DETAILS"] =
                    "uL41/zMDxpBRlnnpbixRIOmFHZGIklmdGp6ZAIhTzByq7HJSXEaOyYDB2FK2WFnT/4Xhh2spvHBGlz0a003HKmEpOOE57ZcEe3ohMqrspBQve2Ophju/AJKWZmbNn29gUStYi5hhyB+YG27SwZbl84iUbqNkhvHEdGzAezqWrASVAZN4tnjdpxoBJLXDFoBTTP93n68sPARNI2TisOM704s7V5dHLu1ntC11H9EsgM0Ng3iXSZrTdRcS30yBlFcOF4vEFRIzZzlMBgB4LFSTkg=="

                var request = chain.request()
                request = request.newBuilder().apply {
                    headers.forEach { (key, value) -> addHeader(key, value) }
                }.build()
                val response = chain.proceed(request)
                return response
            }
        }
        val okHttp = OkHttpClient.Builder().addInterceptor(logger).addInterceptor(headerInterceptor)
        val retrofit = Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(
            GsonConverterFactory.create()
        ).client(
            okHttp.build()
        ).build()

        fun <T> buildServices(service: Class<T>): T {
            return retrofit.create(service)
        }

    }

}
