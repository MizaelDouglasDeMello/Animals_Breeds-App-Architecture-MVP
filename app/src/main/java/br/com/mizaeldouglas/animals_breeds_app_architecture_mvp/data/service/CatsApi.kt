package br.com.mizaeldouglas.animals_breeds_app_architecture_mvp.data.service

import br.com.mizaeldouglas.animals_breeds_app_architecture_mvp.data.model.cats.CatsResponse
import retrofit2.Response
import retrofit2.http.GET

interface CatsApi {

    @GET("images/search")
    suspend fun getCats(): List<CatsResponse>
}