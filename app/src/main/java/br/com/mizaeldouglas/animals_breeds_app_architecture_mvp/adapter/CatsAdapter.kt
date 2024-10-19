package br.com.mizaeldouglas.animals_breeds_app_architecture_mvp.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.mizaeldouglas.animals_breeds_app_architecture_mvp.R
import br.com.mizaeldouglas.animals_breeds_app_architecture_mvp.data.model.cats.CatsResponse
import br.com.mizaeldouglas.animals_breeds_app_architecture_mvp.databinding.ItemAnimalsBinding
import com.squareup.picasso.Picasso

class CatsAdapter(
    private val onItemClick: (CatsResponse) -> Unit
) : RecyclerView.Adapter<CatsAdapter.CatsViewHolder>() {

    private var catsList = mutableListOf<CatsResponse>()

    fun addList(list: List<CatsResponse>) {
        this.catsList.clear()
        this.catsList.addAll(list)
        notifyDataSetChanged()
    }

    inner class CatsViewHolder(val binding: ItemAnimalsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(cats: CatsResponse) {
            val catsUrl = cats.url
            Log.d("ImageAdapter", "Loading image: $catsUrl")

            if (catsUrl != null) {
                Picasso.get()
                    .load(catsUrl)
                    .placeholder(R.drawable.loading)
                    .error(R.drawable.pata_gato)
                    .into(binding.imgAnimal)
            } else {
                Log.d("CatsAdapter", "No image available")
            }
            binding.root.setOnClickListener{
                onItemClick(cats)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemAnimalsBinding.inflate(layoutInflater, parent, false)
        return CatsViewHolder(binding)
    }

    override fun getItemCount(): Int = catsList.size

    override fun onBindViewHolder(holder: CatsViewHolder, position: Int) {
        val cats = catsList[position]
        holder.bind(cats)
    }
}
