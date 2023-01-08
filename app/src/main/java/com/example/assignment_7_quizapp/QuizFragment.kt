package com.example.assignment_7_quizapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class QuizFragment : BaseFragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_quiz, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<RecyclerView>(R.id.recyclerView).layoutManager = LinearLayoutManager(context)

        //launch {
        CoroutineScope(Dispatchers.Main).launch {
            context?.let{
                val quizes = QuizDatabase(it).getDao().getAll()
                Toast.makeText(it,"" + quizes.size,Toast.LENGTH_SHORT).show()
                view.findViewById<RecyclerView>(R.id.recyclerView).adapter = QuizAdapter(quizes,
                    requireContext()
                )
            }
        }
    }
}