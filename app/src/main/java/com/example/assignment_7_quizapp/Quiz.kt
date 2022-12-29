package com.example.assignment_7_quizapp
import androidx.room.Entity
import androidx.room.PrimaryKey

/* Annotate as Entity and define columns of the table,
    it will define the same name in the table column, if you want to provide the different name use as
    @ColumnInfo(name = "note_title") before each column*/
@Entity
data class Quiz(
    @PrimaryKey(autoGenerate = true)
    val question :String,
    val answers :Array<String>,
    var correctAnswer: String,
    var correct: Boolean
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Quiz

        if (question != other.question) return false
        if (!answers.contentEquals(other.answers)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = question.hashCode()
        result = 31 * result + answers.contentHashCode()
        return result
    }
}