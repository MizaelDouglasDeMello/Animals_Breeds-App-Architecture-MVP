package br.com.mizaeldouglas.animals_breeds_app_architecture_mvp.presenter

import br.com.mizaeldouglas.animals_breeds_app_architecture_mvp.data.service.CatsApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CatsPresenter(
    private val view: ICatsPresenter,
    private val catsApi: CatsApi
) {

    private val coroutine = CoroutineScope(Dispatchers.IO)

    fun getCats(){
        view.loading(true)
        coroutine.launch {
            val cat = catsApi.getCats()
            withContext(Dispatchers.Main){
                view.get(cat)
                view.loading(false)
            }
        }
    }

    fun onDestroy(){
        coroutine.cancel()
    }

}