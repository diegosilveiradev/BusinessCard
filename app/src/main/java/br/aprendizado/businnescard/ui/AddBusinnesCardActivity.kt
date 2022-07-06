package br.aprendizado.businnescard.ui

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import br.aprendizado.businnescard.App
import br.aprendizado.businnescard.R
import br.aprendizado.businnescard.data.BusinnesCard
import br.aprendizado.businnescard.databinding.ActivityAddBusinnesCardBinding

class AddBusinnesCardActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityAddBusinnesCardBinding.inflate(layoutInflater)
    }
    private val mainViewModel: MainViewModel by viewModels {

        MainViewModelFactory((application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)



        insertMenu()
        insertListeners()

    }


    private fun insertListeners() {
        binding.btnClose.setOnClickListener {
            finish()
        }
        binding.btnConfirmar.setOnClickListener {


            val businnesCard = BusinnesCard(

                nome = binding.tilNome.editText?.text.toString(),
                telefone = binding.tilTelefone.editText?.text.toString(),
                email = binding.tilEmail.editText?.text.toString(),
                empresa = binding.tilEmpresa.editText?.text.toString(),
                fundoPersonalizado = binding.tilMenuCor.text.toString()
            )

            //binding.tilMenuCor.listSelection.toString()
            mainViewModel.insert(businnesCard)
            Toast.makeText(this, R.string.label_show_sucess, Toast.LENGTH_LONG).show()
            finish()
        }
    }

    private fun insertMenu() {
        val feelings = resources.getStringArray(R.array.feelings)
        val arrayAdapter = ArrayAdapter(this, R.menu.menu_de_cor_cartao, feelings)
        binding.tilMenuCor.setAdapter(arrayAdapter)

    }

}