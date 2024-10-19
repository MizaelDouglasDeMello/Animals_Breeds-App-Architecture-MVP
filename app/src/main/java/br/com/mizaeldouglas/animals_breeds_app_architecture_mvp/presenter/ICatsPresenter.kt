package br.com.mizaeldouglas.animals_breeds_app_architecture_mvp.presenter

import br.com.mizaeldouglas.animals_breeds_app_architecture_mvp.data.model.cats.CatsResponse
import retrofit2.Response

interface ICatsPresenter {

    suspend fun get(cats: List<CatsResponse>)
    fun loading(loading: Boolean)
}