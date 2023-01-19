package com.example.persistencias2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    var KEY = "email"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var email = findViewById<EditText>(R.id.editTextEmail)
        var button = findViewById<Button>(R.id.buttonEnviar)
        var view = findViewById<TextView>(R.id.textView)

        var sharedPreferences = getSharedPreferences("email", MODE_PRIVATE)

        button.setOnClickListener {
            var editor = sharedPreferences.edit()
            editor.putString(KEY, email.text.toString())
            editor.apply()
            val myPrefs = sharedPreferences.getString(KEY, "No existe el valor")
            view.text = myPrefs
        }
        view.text = sharedPreferences.getString(KEY, "No existe el valor").toString()
    }
}
