package com.bast.myfirstapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */

data class Movie(val title: String, val year: Int)

class SecondFragment : Fragment() {

    private lateinit var editText: EditText
    private lateinit var buttonWord: Button
    private lateinit var buttonBack: Button
    private lateinit var rvList: RecyclerView
    private lateinit var rvAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private val listMovie = listOf(
        Movie("Raising Arizona", 1987),
        Movie("Vampire's Kiss", 1988),
        Movie("Con Air", 1997),
        Movie("Gone in 60 Seconds", 1997),
        Movie("National Treasure", 2004),
        Movie("The Wicker Man", 2006),
        Movie("Ghost Rider", 2007),
        Movie("Knowing", 2009)
    )
    private lateinit var list: List<Char>

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        buttonWord = view.findViewById(R.id.buttonWord)
        editText = view.findViewById(R.id.textWord)

        buttonWord.setOnClickListener {
            list = editText.text.toString().toList()
            rvAdapter = MyAdapter(list)

            viewManager = LinearLayoutManager(context)

            rvList = view.findViewById<RecyclerView>(R.id.rvList).apply {
                layoutManager = viewManager
                adapter = rvAdapter
            }
        }

        buttonBack = view.findViewById(R.id.buttonBack)

        buttonBack.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }


    }
}