package com.wahid.evergrow.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface PlantDAO {
    @Insert
    suspend fun insertTask(task: Plant)

    @Query("SELECT * FROM Plant")
    fun loadAllTask(): Flow<List<Plant>>

    @Update
    suspend fun updateTask(task: Plant)

    @Delete
    suspend fun deleteTask(task: Plant)


}