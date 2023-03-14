package com.yeet.adv160420011week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.Navigation
import kotlin.random.Random

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {
    private var r1 = 0
    private var r2 = 0
    var res = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var score = 0
        val txtNums = view.findViewById<TextView>(R.id.txtNums)
        getRand(txtNums)

        val btnStart = view.findViewById<Button>(R.id.btnStart)
        btnStart.setOnClickListener {
            val txtName = view.findViewById<TextView>(R.id.txtName)
            val ans = txtName.text.toString().toInt()

            if (ans == res) {
                score++
                getRand(txtNums)
                txtName.text = ""
            } else {
                val action = MainFragmentDirections.actionGameFragment(score.toString())
                Navigation.findNavController(it).navigate(action)
                score = 0
            }
        }
    }

    fun getRand(t: TextView) {
        r1 = Random.nextInt(1, 100)
        r2 = Random.nextInt(1, 100)
        res = r1 + r2
        t.text = "$r1 + $r2 ="
    }
}