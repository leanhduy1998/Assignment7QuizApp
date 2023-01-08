package com.example.assignment_7_quizapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class QuizAdapter(private val quizes: List<Quiz>, val context: Context) :
    RecyclerView.Adapter<QuizAdapter.QuizViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            QuizAdapter.QuizViewHolder {
        return QuizViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_quiz, parent, false)
        )
    }
    override fun getItemCount() = quizes.size
    override fun onBindViewHolder(holder: QuizAdapter.QuizViewHolder, position: Int) {
        holder.question.text = quizes[position].question
        holder.answer1.text = quizes[position].answer1
        holder.answer2.text = quizes[position].answer2
        holder.answer3.text = quizes[position].answer3
        holder.answer4.text = quizes[position].answer4

        holder.radioGroup.setOnCheckedChangeListener { group, id ->
            CoroutineScope(Dispatchers.Main).launch {
                context?.let{
                 //   val selectedOption: Int = holder.radioGroup.checkedRadioButtonId
                    val answer = holder.itemView.findViewById<RadioButton>(id).text.toString()
                    var quiz = quizes[position]
                    quiz.answer = answer
                    QuizDatabase(context).getDao().add(quiz)
                }
            }
        }


    }
    inner class QuizViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val question = itemView.findViewById<TextView>(R.id.questionTextView)
        val answer1 = itemView.findViewById<RadioButton>(R.id.answer1)
        val answer2 = itemView.findViewById<RadioButton>(R.id.answer2)
        val answer3 = itemView.findViewById<RadioButton>(R.id.answer3)
        val answer4 = itemView.findViewById<RadioButton>(R.id.answer4)
        val radioGroup = itemView.findViewById<RadioGroup>(R.id.radioGroup)
    }
}