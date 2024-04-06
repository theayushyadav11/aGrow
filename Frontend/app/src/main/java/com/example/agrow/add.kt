package com.example.agrow

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class add : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add)

    }
    fun submit(v: View)
    {
        Toast.makeText(this, "Product Added", Toast.LENGTH_SHORT).show()
        startActivity(Intent(this,MainActivity::class.java))
    }
}