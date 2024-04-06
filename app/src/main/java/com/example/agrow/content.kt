package com.example.agrow

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.agrow.databinding.ActivityContentBinding

class content : AppCompatActivity() {
lateinit var binding:ActivityContentBinding
    var data:ArrayList<Model> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding=ActivityContentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        addDetails()
        val inflater = LayoutInflater.from(this)
        for(i in 0..4) {
            val card = inflater.inflate(R.layout.list_item, null)



            binding.adder.addView(card)

            card.findViewById<ImageView>(R.id.thumb).setImageResource(data[i].img)
            card.findViewById<TextView>(R.id.Head).setText(data[i].title)
            card.findViewById<TextView>(R.id.test).setText(data[i].price)
            card.findViewById<LinearLayout>(R.id.rent).setOnClickListener{
                val builder = AlertDialog.Builder(this)

                // Set dialog title and message
                builder.setTitle("Rented a Product")
                    .setMessage("The product listed was rented!")

                // Set positive button and its click listener
                builder.setPositiveButton("OK") { dialogInterface: DialogInterface, _: Int ->
                    // Dismiss the dialog
                    startActivity(Intent(this@content,MainActivity::class.java))
                    dialogInterface.dismiss()
                }

                // Create and show the AlertDialog
                val alertDialog = builder.create()
                alertDialog.show()
            }
        }

    }
    fun addDetails()
    {
        var index=intent.getIntExtra("dataIndex",0)
        if(index==1)
        {
            data.add(Model(R.drawable.trac1,"John Deer Tractor","Rs.250/hr","Rent"))
            data.add(Model(R.drawable.trac2,"Heavy Duty Tractor","Rs.500/hr","Rent"))
            data.add(Model(R.drawable.trac3,"Sonalika Tiger Tractor","Rs.350/hr","Rent"))
            data.add(Model(R.drawable.trac4,"Eicher Tractor","Rs.250/hr","Rent"))
            data.add(Model(R.drawable.trac5,"Mahindra Tractor","Rs.450/hr","Rent"))
        }
        else if(index==2)
        {
            data.add(Model(R.drawable.thr1,"Red Heavy Duty Threshor","Rs.600/hr","Rent"))
            data.add(Model(R.drawable.thr2,"Wheat Threshor","Rs.500/hr","Rent"))
            data.add(Model(R.drawable.thr3,"Bharatpur Brand Threshor","Rs.850/hr","Rent"))
            data.add(Model(R.drawable.thr4,"Kisan Marka ","Rs.250/hr","Rent"))
            data.add(Model(R.drawable.thr5,"Legend machine works","Rs.450/hr","Rent"))

        }
        else if(index==3)
        {
            data.add(Model(R.drawable.harv1,"Red Heavy Duty Harvestor","Rs.1600/hr","Rent"))
            data.add(Model(R.drawable.harv2,"Wheat Harvestor","Rs.1500/hr","Rent"))
            data.add(Model(R.drawable.harv3,"Bharatpur Brand Harvestor","Rs.1850/hr","Rent"))
            data.add(Model(R.drawable.harv4,"Kisan Markaarvestor ","Rs.250/hr","Rent"))
            data.add(Model(R.drawable.harv5,"Legend machine works","Rs.1450/hr","Rent"))

        }
        else if(index==4)
        {
            data.add(Model(R.drawable.spray1,"Electric Sprayer","Rs.100/hr","Rent"))
            data.add(Model(R.drawable.spray2,"Gas Sprayer","Rs.500/hr","Rent"))
            data.add(Model(R.drawable.spray3,"Hand drawn spray machine","Rs.50/hr","Rent"))
            data.add(Model(R.drawable.spray4,"Hydraulic gas sprayer","Rs.250/hr","Rent"))
            data.add(Model(R.drawable.spray5,"Back fertiliser sprayer","Rs.450/hr","Rent"))

        }



    }
    fun back(v: View)
    {
        onBackPressed()
    }
}