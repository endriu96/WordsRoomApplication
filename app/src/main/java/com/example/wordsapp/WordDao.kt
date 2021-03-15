package com.example.wordsapp

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface WordDao {
    @Query("SELECT * FROM words_table ORDER BY word ASC")
    fun getAlphabetizedWords(): Flow<List<Word>>

    @Insert(onConflict =OnConflictStrategy.REPLACE)
    suspend fun insert(word: Word)



    @Query("DELETE FROM words_table")
    suspend fun deleteAll()



}