package fr.epita.android.tictactoe

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_tictactoe.*

class tictactoe : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tictactoe)

        main_button_start.setOnClickListener {
            var intent = Intent(this@tictactoe, Result::class.java)
            startActivity(intent)
        }
    }
}
