package br.com.mizaeldouglas.animals_breeds_app_architecture_mvp.data.model.cats
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CatsResponse(
    val breeds: List<Breed>,
    val height: Int,
    val id: String,
    val url: String?,
    val width: Int
): Parcelable