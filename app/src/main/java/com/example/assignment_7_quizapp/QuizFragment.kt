package com.example.assignment_7_quizapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class QuizFragment : Fragment() {
    var quizes: Array<Quiz> = arrayOf(
        Quiz("Kotlin is ___ interoperable with the Java programming language.", arrayOf(
            "50%",
            "80%",
            "98%",
            "100%",
        ), "98%", false),
        Quiz("Your code need to try casting an object. If the cast is not possible, you do not want an exception generated, instead you want null to be assigned. Which operator can safely cast a value?", arrayOf(
            "as?",
            "??",
            "is",
            "as",
        ), "as?", false),
        Quiz("You are attempting to assign an integer variable to a long variable, but Kotlin compiler flags it as an error. Why?", arrayOf(
            "You must wrap all implicit conversion in a try/catch block",
            "You can only assign Long to an Int, not the other way around",
            "There is no implicit conversion from Int to Long",
            "All integers in Kotlin are of type Long",
        ), "There is no implicit conversion from Int to Long", false),
        Quiz("Which function changes the value of the element at the current iterator location?", arrayOf(
            "change()",
            "modify()",
            "set()",
            "assign()",
        ), "set()", false),
        Quiz("Which line of code shows how to display a nullable string's length and shows 0 instead of null?", arrayOf(
            "println(b!!.length ?: 0)",
            "println(b?.length ?: 0)",
            "println(b?.length ?? 0)",
            "println(b == null? 0: b.length)",
        ), "println(b?.length ?: 0)", false),


        Quiz("Kotlin interfaces ad abstract classes are very similar. What is one thing abstract class can do that interfaces cannot?", arrayOf(
            "Only abstract classes are inheritable by subclasses",
            "Only abstract classes can inherit from multiple superclasses",
            "Only abstract classes can have abstract methods",
            "Only abstract classes can store state",
        ), "Only abstract classes can store state", false),
        Quiz("You are writing a console app in Kotlin that processes test entered by the user. If the user enters an empty string, the program exits. Which kind of loop would work best for this app? Keep in mind that the loop is entered at least once", arrayOf(
            "a do..while loop",
            "a for loop",
            "a while loop",
            "a forEach loop",
        ), "a do..while loop", false),
        Quiz("Inside an extension function, what is the name of the variable that corresponds to the receiver object", arrayOf(
            "The variable is named it",
            "The variable is named this",
            "The variable is named receiver",
            "The variable is named default",
        ), "The variable is named this", false),
        Quiz("What is the entry point for a Kotlin application?", arrayOf(
            "fun static main(){}",
            "fun main(){}",
            "fun Main(){}",
            "public static void main(){}",
        ), "fun main(){}", false),
        Quiz("Which code snippet correctly shows a for loop using a range to display \"1 2 3 4 5 6\"?", arrayOf(
            "for(z in 1..7) println(\"\$z \")",
            "for(z in 1..6) print(\"\$z \")",
            "for(z in 1 to 6) print(\"\$z \")",
            "for(z in 1..7) print(\"\$z \")",
        ), "for(z in 1..6) print(\"\$z \")", false),


        Quiz("You are upgrading a Java class to Kotlin. What should you use to replace the Java class's static fields?", arrayOf(
            "an anonymous object",
            "a static property",
            "a companion object",
            "a backing field",
        ), "a companion object", false),
        Quiz("The function typeChecker receiver a parameter obj of type Any. Based upon the type of obj, it prints different messages for Int, String, Double, and Float types; if not any of the mentioned types, it prints \"unknown type\". What operator allows you to determine the type of an object?", arrayOf(
            "instanceof",
            "is",
            "typeof",
            "as",
        ), "is", false),

    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quiz, container, false)
    }
}