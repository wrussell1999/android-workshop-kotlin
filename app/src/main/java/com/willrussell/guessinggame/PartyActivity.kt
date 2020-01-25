package com.willrussell.guessinggame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class PartyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_party)
    }

    fun tryAgain(v: View) {
        finish() // Finish the activity
    }
}
