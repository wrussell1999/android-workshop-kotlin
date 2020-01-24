package com.willrussell.guessinggame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
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
        
        inputEditText!!.setOnEditorActionListener { v, actionId, event ->
            if ((event?.keyCode == KeyEvent.KEYCODE_ENTER) || (actionId == EditorInfo.IME_ACTION_DONE)) {
                checkGuess(v)

            }
            false
        }
    }

    fun generateNumber() {
        randomNumber = Random.nextInt(10)
    }

    fun checkGuess(v: View) {
        val input = inputEditText!!.text.toString()
        if (input != "") {
            val guessedValue = Integer.parseInt(input)

            if (guessedValue == randomNumber) {
                val intent = Intent(this, PartyActivity::class.java)
                startActivityForResult(intent, 1);

            } else {
                numberView!!.text = resources.getString(R.string.guess_incorrect_label)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1) {
            generateNumber()
        }
    }
}
