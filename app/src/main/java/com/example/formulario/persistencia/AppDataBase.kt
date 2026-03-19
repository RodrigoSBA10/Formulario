package com.example.formulario.persistencia

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Usuario::class], version = 1)
abstract class AppDataBase /*private constructor()*/: RoomDatabase (){
    abstract fun usuarioDao(): UsuarioDAO

    companion object{
        @Volatile
        private var INSTANCE: AppDataBase?=null
        fun getDataBase(context: Context): AppDataBase{
            return INSTANCE?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    "database_usuarios"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}