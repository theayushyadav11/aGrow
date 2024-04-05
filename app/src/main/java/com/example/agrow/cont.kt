package com.example.agrow

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.agrow.databinding.ActivityContBinding

class cont : AppCompatActivity() {
    private lateinit var binding: ActivityContBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityContBinding.inflate(layoutInflater)
        setContentView(binding.root)









        binding.btnGet.setOnClickListener {

            if (binding.etPhone.text.length == 10) {
                val intent = Intent(this, verify::class.java)
                intent.putExtra("phone", binding.etPhone.text.toString())
                startActivity(intent)
            } else {
                Toast.makeText(this, "invalid number ", Toast.LENGTH_SHORT).show()
            }
        }

    }
}