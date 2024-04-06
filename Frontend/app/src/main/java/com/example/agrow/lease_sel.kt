package com.example.agrow

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.agrow.databinding.ActivityLeaseSelBinding

class lease_sel : AppCompatActivity() {
    lateinit var binding:ActivityLeaseSelBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLeaseSelBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button3.setOnClickListener(View.OnClickListener {        startActivity( Intent(this@lease_sel,lease::class.java)) })

        binding.button2.setOnClickListener(View.OnClickListener {        startActivity( Intent(this@lease_sel,lease_yl::class.java)) })


    }
}