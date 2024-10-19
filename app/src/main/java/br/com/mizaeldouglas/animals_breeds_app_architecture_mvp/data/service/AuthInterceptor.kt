package br.com.mizaeldouglas.animals_breeds_app_architecture_mvp.data.service

import br.com.mizaeldouglas.animals_breeds_app_architecture_mvp.data.service.RetrofitService.API_KEY
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val originalUrl = originalRequest.url

        val newUrl = originalUrl.newBuilder()
            .addQueryParameter("limit", "100")
            .addQueryParameter("breed_ids", "beng,abys,ctif,rblu,raga,jbob,chee,emau,cymr")
            .addQueryParameter("api_key", API_KEY)
            .build()

        val requestWithAuth = originalRequest.newBuilder()
            .url(newUrl)
            .build()

        return chain.proceed(requestWithAuth)
    }
}

