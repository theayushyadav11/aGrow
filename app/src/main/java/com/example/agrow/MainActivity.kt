package com.example.agrow

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.agrow.databinding.ActivityLeaseBinding
import com.example.agrow.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)







        binding.btnLease.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this@MainActivity,lease_sel::class.java))
        })




    }
    fun trac(v: View)
    {

    }
    fun thresher(v: View)
    {

    }
    fun harvest(v: View)
    {

    }
    fun spray(v: View)
    {

    }
    fun lease(v: View)
    {
        startActivity(Intent(this@MainActivity,lease_sel::class.java))

    }
}