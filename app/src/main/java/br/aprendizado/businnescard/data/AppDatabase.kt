package br.aprendizado.businnescard.data

import android.content.Context
import androidx.room.Database

import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [BusinnesCard::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun businnesDao():BusinnesCardDao

    companion object{
        @Volatile
        private var INSTANCE: AppDatabase?=null

        fun getDatabase(context: Context):AppDatabase{

            return INSTANCE ?: synchronized(this){
                    val instance= Room.databaseBuilder(context.applicationContext,
                        AppDatabase::class.java,
                        "businnesCard_db"
                    ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}