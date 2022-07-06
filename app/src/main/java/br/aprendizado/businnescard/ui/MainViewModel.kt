package br.aprendizado.businnescard.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.aprendizado.businnescard.data.BusinnesCard
import br.aprendizado.businnescard.data.BusinnesCardRepository

class MainViewModel(private val businnesCardRepository: BusinnesCardRepository) : ViewModel() {

    fun insert(businnesCard: BusinnesCard){

        businnesCardRepository.insert(businnesCard)
    }

    fun getAll (): LiveData<List<BusinnesCard>>{

        return businnesCardRepository.getAll()
    }

}

class MainViewModelFactory(private val repository: BusinnesCardRepository):ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknow ViewModel class")
    }


}