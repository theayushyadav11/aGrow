
package com.example.agrow

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.agrow.databinding.ActivityVerifyBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.firestore.FirebaseFirestore

class verify : AppCompatActivity() {
    private lateinit var binding: ActivityVerifyBinding
    private lateinit var verificationId: String
    private lateinit var phoneNumber: String
    private lateinit var mAuth: FirebaseAuth
    private lateinit var firestore: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
<<<<<<<<< Temporary merge branch 1
        binding = ActivityVerifyBinding.inflate(layoutInflater)
=========
        binding=ActivityVerifyBinding.inflate(layoutInflater)

>>>>>>>>> Temporary merge branch 2
        setContentView(binding.root)

        mAuth = FirebaseAuth.getInstance()
        firestore = FirebaseFirestore.getInstance()

        verificationId = intent.getStringExtra("verificationId") ?: ""
        phoneNumber = intent.getStringExtra("phoneNumber") ?: ""

        binding.btnVerify.setOnClickListener {
            val otp = binding.pinOTP.text.toString()
            if (otp.isNotEmpty()) {
                val credential = PhoneAuthProvider.getCredential(verificationId, otp)
                signInWithPhoneAuthCredential(credential)
            } else {
                Toast.makeText(this, "Please enter OTP", Toast.LENGTH_SHORT).show()
            }
        }
<<<<<<<<< Temporary merge branch 1
    }

    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
        mAuth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    checkPhoneNumberInDatabase()
                } else {
                    Toast.makeText(this, "Verification failed", Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun checkPhoneNumberInDatabase() {
        val usersRef = firestore.collection("users")
        usersRef.whereEqualTo("phone", phoneNumber)
            .get()
            .addOnSuccessListener { documents ->
                if (documents.isEmpty) {
                    addUserToDatabase()
                } else {
                    navigateToHomeActivity()
                }
            }
            .addOnFailureListener { exception ->
                Toast.makeText(this, "Error: ${exception.message}", Toast.LENGTH_SHORT).show()
            }
    }

    private fun addUserToDatabase() {
        val usersRef = firestore.collection("users")
        usersRef.document(phoneNumber)
            .set(mapOf("phone" to phoneNumber))
            .addOnSuccessListener {
                navigateToHomeActivity()
            }
            .addOnFailureListener { exception ->
                Toast.makeText(this, "Error: ${exception.message}", Toast.LENGTH_SHORT).show()
            }
    }

    private fun navigateToHomeActivity() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }
=========
        binding.tvPhone.setText(binding.tvPhone.text.toString()+intent.getStringExtra("phone"))
        binding.btnVerify.setOnClickListener{
            var otp=binding.pinOTP.text.toString()
            if(otp.length==6)
            {
                val i= Intent(this,MainActivity::class.java)
                startActivity(i)
            }
        }



    }
>>>>>>>>> Temporary merge branch 2
}
