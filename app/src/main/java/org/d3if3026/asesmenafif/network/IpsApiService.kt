package org.d3if3026.asesmenafif.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.d3if3026.asesmenafif.model.HasilMotivasi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


private const val BASE_URL = "https://raw.githubusercontent.com/" +
        "AfifAslami/IpsAPI/main/"

private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

private val retrofit =
    Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(BASE_URL)
        .build()

interface IpsApiService {
    @GET("static-api.json")
    suspend fun getIps(): List<HasilMotivasi>
}
object IpsApi {
    val service: IpsApiService by lazy {
        retrofit.create(IpsApiService::class.java)
    }

    fun getMotivasiUrl(imageId: String): String {
        return "$BASE_URL$imageId.jpg"
    }

}

enum class ApiStatus {
    LOADING, SUCCESS, FAILED
}