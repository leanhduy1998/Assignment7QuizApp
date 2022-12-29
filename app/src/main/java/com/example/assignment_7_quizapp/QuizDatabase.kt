package com.example.assignment_7_quizapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
/* Database class should be abstract and annotated with @Database and pass all entities as an
array so use [] brackets and specify the version number, in future if you want to change the DB
schema and change the version number and create migration class to change database structure
*/
@Database(
    entities = [Quiz::class],
    version = 1
)
abstract class QuizDatabase():RoomDatabase() {
    abstract fun getDao() : QuizDAO
    // Build RoomDB
    companion object {
        // meaning that writes to this field
        // * are immediately made visible to other threads
        @Volatile private var instance : QuizDatabase? = null
        private val LOCK = Any() // The root of the Kotlin class hierarchy. Every Kotlin class has [Any] as a superclass.
        // Invoke check if the instance is not null return the instance, if it is null
        // synchronized block work, inside this also check null or not and call the function buildDatabase
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }
        // Function to build database
        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            QuizDatabase::class.java,
            "quizdatabase"
        ).build()
    }
}