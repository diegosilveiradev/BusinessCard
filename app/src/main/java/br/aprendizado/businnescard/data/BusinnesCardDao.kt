package br.aprendizado.businnescard.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BusinnesCardDao {

    @Query("SELECT * FROM BusinnesCard ")
    fun getAll(): LiveData<List<BusinnesCard>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(businnesCard: BusinnesCard)

}