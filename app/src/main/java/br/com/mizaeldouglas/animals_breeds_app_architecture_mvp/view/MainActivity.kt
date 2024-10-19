package br.com.mizaeldouglas.animals_breeds_app_architecture_mvp.view

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import br.com.mizaeldouglas.animals_breeds_app_architecture_mvp.adapter.CatsAdapter
import br.com.mizaeldouglas.animals_breeds_app_architecture_mvp.data.model.cats.CatsResponse
import br.com.mizaeldouglas.animals_breeds_app_architecture_mvp.data.service.RetrofitService
import br.com.mizaeldouglas.animals_breeds_app_architecture_mvp.databinding.ActivityMainBinding
import br.com.mizaeldouglas.animals_breeds_app_architecture_mvp.presenter.CatsPresenter
import br.com.mizaeldouglas.animals_breeds_app_architecture_mvp.presenter.ICatsPresenter

class MainActivity : AppCompatActivity(), ICatsPresenter {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val catsApi by lazy {
        RetrofitService.api
    }
    private lateinit var catsAdapter: CatsAdapter
    private lateinit var catsPresenter: CatsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        initView()


        catsPresenter = CatsPresenter(this, catsApi)
    }

    private fun initView() {
        catsAdapter = CatsAdapter(){ cat ->
            Toast.makeText(this, "${cat.breeds.firstOrNull()?.name}", Toast.LENGTH_SHORT).show()
            Log.i("initView", "initView: ${cat.breeds.firstOrNull()?.description}")
        }
        binding.rvListAnimals.adapter = catsAdapter
        binding.rvListAnimals.layoutManager = GridLayoutManager(this, 3)
    }

    override fun onStart() {
        super.onStart()
        catsPresenter.getCats()
    }

    override fun onDestroy() {
        super.onDestroy()
        catsPresenter.onDestroy()
    }

    override suspend fun get(cats: List<CatsResponse>) {
        try {
            catsAdapter.addList(cats)

        } catch (e: Exception) {
            Log.i("get_error", "get: ${e.message}")
        }
    }

    override fun loading(loading: Boolean) {
        if (loading){
            binding.progressBar.visibility = View.VISIBLE
        }else{
            binding.progressBar.visibility = View.GONE
        }
    }
}
