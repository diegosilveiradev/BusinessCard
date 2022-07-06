package br.aprendizado.businnescard

import android.app.Application
import br.aprendizado.businnescard.data.AppDatabase
import br.aprendizado.businnescard.data.BusinnesCardRepository

class App : Application() {

    val database by lazy{AppDatabase.getDatabase(this)}
    val repository by lazy{BusinnesCardRepository(database.businnesDao())}
}