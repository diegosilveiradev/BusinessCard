package br.aprendizado.businnescard.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class BusinnesCardRepository (private val dao:BusinnesCardDao){

    fun insert(businnesCard: BusinnesCard) = runBlocking {
        launch(Dispatchers.IO) {
            dao.insert(businnesCard)
        }
    }

    fun getAll() = dao.getAll()
}