package com.example.assignment_7_quizapp

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface QuizDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun add(quiz: Quiz)
    @Query("SELECT * FROM QUIZ")
    suspend fun getAll(): List<Quiz>
    @Query("DELETE FROM QUIZ")
    suspend fun removeAll()
}