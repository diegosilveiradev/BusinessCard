package br.aprendizado.businnescard.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import br.aprendizado.businnescard.App
import br.aprendizado.businnescard.databinding.ActivityMainBinding
import br.aprendizado.businnescard.util.Image

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val mainViewModel: MainViewModel by viewModels {

        MainViewModelFactory((application as App).repository)
    }

    private val adapter by lazy {
        BusinnesCardAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.rvCard.adapter = adapter
        getAllBusinnesCard()
        insertListeners()


    }

    private fun insertListeners() {
        binding.fabAdd.setOnClickListener {

            val intent = Intent(this, AddBusinnesCardActivity::class.java)
            startActivity(intent)
        }
        adapter.listenerShare = { card ->

            Image.share(this,card)
        }
    }

    private fun getAllBusinnesCard() {
        mainViewModel.getAll().observe(this, { businnesCard ->
            adapter.submitList(businnesCard)
        })
    }
}