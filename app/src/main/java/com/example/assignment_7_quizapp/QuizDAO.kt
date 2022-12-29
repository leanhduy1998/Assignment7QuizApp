package com.example.assignment_7_quizapp

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface QuizDAO {
    @Insert
    suspend fun add(quiz: Quiz)
    @Query("SELECT * FROM QUIZ")
    suspend fun getAll(): List<Quiz>
}