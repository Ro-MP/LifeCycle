package com.example.lifecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private lateinit var button: Button
    private lateinit var timer: Timer


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Se inicializa el objeto con el Lifecycle object que la activity posee
        timer = Timer(this.lifecycle)

        button = findViewById(R.id.btn_activity)
        button.setOnClickListener {
            startActivity(Intent(this, DialogActivity::class.java))
        }

        // Inicializa timber library
        Timber.plant(Timber.DebugTree())
        // Implementacion de Timber en vez de log
        Timber.i("onCreate called")
        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show()
    }

    override fun onStart() {
        super.onStart()
        Log.i("LyfeCycle", "OnStart")
        Toast.makeText(this, "OnStart", Toast.LENGTH_SHORT).show()
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("LyfeCycle", "OnRestart")
        Toast.makeText(this, "OnRestart", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Log.i("LyfeCycle", "OnResume")
        Toast.makeText(this, "OnResume", Toast.LENGTH_SHORT).show()


    }

    override fun onPause() {
        super.onPause()
        Log.i("LyfeCycle", "OnPause")
        Toast.makeText(this, "OnPause", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Log.i("LyfeCycle", "onStop")
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("LyfeCycle", "onDestroy")
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show()
    }
}