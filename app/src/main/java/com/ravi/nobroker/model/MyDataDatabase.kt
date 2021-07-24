package com.example.guessmyage.Models

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MyDataEntity::class], version = 1)
abstract class MyDataDatabase : RoomDatabase(){

    abstract fun getMyAgeDao(): MyDataDao

    companion object{

        private var INSTANCE: MyDataDatabase? = null

        fun getDatabase(context: Context): MyDataDatabase{
            if (INSTANCE == null){
                val builder = Room.databaseBuilder(
                    context.applicationContext,
                    MyDataDatabase::class.java,
                    "age_database"
                )

                builder.fallbackToDestructiveMigration()
                INSTANCE =  builder.build()

                return INSTANCE!!
            }else{
                return INSTANCE!!
            }
        }

    }

}
