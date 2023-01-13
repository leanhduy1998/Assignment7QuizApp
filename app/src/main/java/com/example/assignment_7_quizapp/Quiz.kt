package com.example.assignment_7_quizapp
import androidx.room.Entity
import androidx.room.PrimaryKey

/* Annotate as Entity and define columns of the table,
    it will define the same name in the table column, if you want to provide the different name use as
    @ColumnInfo(name = "note_title") before each column*/
@Entity
data class Quiz(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val question :String,
    val answer1 :String,
    val answer2 :String,
    val answer3 :String,
    val answer4 :String,
    var correctAnswer: String,
    var answer: String = "",
)