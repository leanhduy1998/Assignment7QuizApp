package com.example.assignment_7_quizapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment_7_quizapp.databinding.FragmentFirstBinding
import com.example.assignment_7_quizapp.databinding.FragmentQuizBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class QuizFragment : BaseFragment() {
    private var _binding: FragmentQuizBinding? = null
    private val binding get() = _binding!!
    private var position = 0
    private var quizzes: List<Quiz> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQuizBinding.inflate(inflater, container, false)
        return inflater.inflate(R.layout.fragment_quiz, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        view.findViewById<Button>(R.id.homeButton).setOnClickListener {
            val directions = QuizFragmentDirections.actionQuizFragmentToFirstFragment()
            findNavController().navigate(directions)
        }

        view.findViewById<Button>(R.id.nextButton).setOnClickListener {
                val radioGroup = view.findViewById<RadioGroup>(R.id.radioGroup)
                if (radioGroup.checkedRadioButtonId != -1) {
                    val selectedOption: Int = radioGroup.checkedRadioButtonId

                    val answer = view.findViewById<RadioButton>(selectedOption).text.toString()
                    var quiz = quizzes[position]
                    quiz.answer = answer

                    CoroutineScope(Dispatchers.Main).launch {
                        context?.let{
                            QuizDatabase(requireContext()).getDao().add(quiz)
                        }
                    }
                    position += 1
                    val temp = position
                    val temp2 = quizzes.size

                    if (position < quizzes.size) {
                        val question = view.findViewById<TextView>(R.id.questionTextView)
                        val answer1 = view.findViewById<RadioButton>(R.id.answer1)
                        val answer2 = view.findViewById<RadioButton>(R.id.answer2)
                        val answer3 = view.findViewById<RadioButton>(R.id.answer3)
                        val answer4 = view.findViewById<RadioButton>(R.id.answer4)

                        question.text = quizzes[position].question
                        answer1.text = quizzes[position].answer1
                        answer2.text = quizzes[position].answer2
                        answer3.text = quizzes[position].answer3
                        answer4.text = quizzes[position].answer4

                        radioGroup.clearCheck()
                    } else {
                        val directions = QuizFragmentDirections.actionQuizFragmentToResultFragment()
                        findNavController().navigate(directions)
                    }

            }
        }

        CoroutineScope(Dispatchers.Main).launch {
            context?.let{
                val quizes = QuizDatabase(it).getDao().getAll()
                quizzes = quizes

                val question = view.findViewById<TextView>(R.id.questionTextView)
                val answer1 = view.findViewById<RadioButton>(R.id.answer1)
                val answer2 = view.findViewById<RadioButton>(R.id.answer2)
                val answer3 = view.findViewById<RadioButton>(R.id.answer3)
                val answer4 = view.findViewById<RadioButton>(R.id.answer4)

                question.text = quizzes[0].question
                answer1.text = quizes[0].answer1
                answer2.text = quizes[0].answer2
                answer3.text = quizes[0].answer3
                answer4.text = quizes[0].answer4
            }
        }
    }
}