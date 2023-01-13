package com.example.assignment_7_quizapp

import android.os.Build
import android.os.Bundle
import android.text.Html
import android.text.method.ScrollingMovementMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ResultFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.home2Button).setOnClickListener {
            val directions = ResultFragmentDirections.actionResultFragmentToFirstFragment()
            findNavController().navigate(directions)
        }

        view.findViewById<TextView>(R.id.resultTextView).movementMethod = ScrollingMovementMethod()

        CoroutineScope(Dispatchers.Main).launch {
            context?.let{ it ->
                val quizes = QuizDatabase(it).getDao().getAll()
                var result = "Total questions: " + quizes.size + "<br>"
                var score = quizes.filter { quiz -> quiz.answer == quiz.correctAnswer }
                result += "Score: " + score.size + "/" + quizes.size + "<br>"
                result += "<br> <br>"
                quizes.forEach { quiz ->
                    result += "<b> Question: " + quiz.question + "</b> <br>"
                    result += "Answered: " + quiz.answer + "<br>"
                    result += "Correct Answer: " + quiz.correctAnswer + "<br><br>"
                }

                view.findViewById<TextView>(R.id.resultTextView).text = Html.fromHtml(result, Html.FROM_HTML_MODE_COMPACT)
            }
        }
    }
}