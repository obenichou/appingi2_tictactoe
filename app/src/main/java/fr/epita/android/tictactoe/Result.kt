package fr.epita.android.tictactoe

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity

class Result : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.result)
    }
}