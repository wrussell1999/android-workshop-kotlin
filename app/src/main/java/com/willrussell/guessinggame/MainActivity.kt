package com.willrussell.guessinggame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private var randomNumber: Int = 0
    private var numberView: TextView? = null
    private var inputEditText: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        numberView = findViewById(R.id.number_view)
        inputEditText = findViewById(R.id.user_input)
        generateNumber()
    }

    fun generateNumber() {
        randomNumber = Random.nextInt(10)
    }

    fun checkGuess(v: View) {
        val input = inputEditText!!.text.toString()
        val guessedValue = Integer.parseInt(input)

        if (guessedValue == randomNumber) {
            numberView!!.text = resources.getString(R.string.guess_correct_label)
            generateNumber()
        } else {
            numberView!!.text = resources.getString(R.string.guess_incorrect_label)
        }
    }
}
