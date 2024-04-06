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
        binding.prooo.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this@MainActivity,Profile::class.java))
        })
    }
    fun trac(v: View)
    {

        var i=Intent(this@MainActivity,content::class.java)
        i.putExtra("dataIndex",1)
        startActivity(i)
    }
    fun thresher(v: View)
    {
        var i=Intent(this@MainActivity,content::class.java)
        i.putExtra("dataIndex",2)
        startActivity(i)

    }
    fun harvest(v: View)
    {
        var i=Intent(this@MainActivity,content::class.java)
        i.putExtra("dataIndex",3)
        startActivity(i)
    }
    fun spray(v: View)
    {

        var i=Intent(this@MainActivity,content::class.java)
        i.putExtra("dataIndex",4)
        startActivity(i)


    }
    fun lease(v: View)
    {
        startActivity(Intent(this@MainActivity,lease_sel::class.java))

    }
    fun cli1(v: View)
    {
        startActivity(Intent(this@MainActivity,content::class.java))

    }
    fun cli2(v: View)
    {
        startActivity(Intent(this@MainActivity,content::class.java))

    }
    fun cli3(v: View)
    {
        startActivity(Intent(this@MainActivity,content::class.java))

    }
    fun cli4(v: View)
    {
        startActivity(Intent(this@MainActivity,content::class.java))

    }
    fun add(v: View)
    {
        startActivity(Intent(this@MainActivity,add::class.java))

    }
    fun pro(v: View)
    {
        startActivity(Intent(this@MainActivity,Profile::class.java))

    }
}