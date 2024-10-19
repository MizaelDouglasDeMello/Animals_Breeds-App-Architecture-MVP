package br.com.mizaeldouglas.animals_breeds_app_architecture_mvp.data.model.cats
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Weight(
    val imperial: String,
    val metric: String
): Parcelable