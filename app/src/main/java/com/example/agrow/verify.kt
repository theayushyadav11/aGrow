package com.example.agrow

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.agrow.databinding.ActivityContBinding
import com.example.agrow.databinding.ActivityVerifyBinding

class verify : AppCompatActivity() {
    private lateinit var binding:ActivityVerifyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
enableEdgeToEdge()
        binding=ActivityVerifyBinding.inflate(layoutInflater)

        setContentView(binding.root)
        binding.ivBack.setOnClickListener{
            onBackPressed()
        }


    }
}