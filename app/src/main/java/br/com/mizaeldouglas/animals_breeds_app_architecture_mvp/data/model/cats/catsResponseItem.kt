package br.com.mizaeldouglas.animals_breeds_app_architecture_mvp.data.model.cats

data class catsResponseItem(
    val breeds: List<Breed>,
    val height: Int,
    val id: String,
    val url: String,
    val width: Int
)