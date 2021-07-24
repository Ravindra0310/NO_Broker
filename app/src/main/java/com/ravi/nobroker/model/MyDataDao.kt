package com.example.guessmyage.Models
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface MyDataDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(myDataEntity: MyDataEntity)

    @Query("select * from my_data_table")
    fun getTask(): LiveData<List<MyDataEntity>>

    @Query("SELECT * FROM my_data_table WHERE title LIKE :searchQuery")
    fun searchDatabase(searchQuery: String): Flow<List<MyDataEntity>>
}