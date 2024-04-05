package com.example.agrow

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.agrow.databinding.ActivityContBinding
import com.google.common.base.Verify
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import java.util.concurrent.TimeUnit

class cont : AppCompatActivity() {
    private lateinit var binding: ActivityContBinding
    private lateinit var phoneNumber: String
    private var timeoutSeconds: Long = 60L
    private lateinit var verificationId: String
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityContBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mAuth = FirebaseAuth.getInstance()

        binding.btnGet.setOnClickListener {
            phoneNumber = binding.etPhone.text.toString()
            if (phoneNumber.length == 10) {
                sendOtp(phoneNumber)
            } else {
                Toast.makeText(this, "Invalid number", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun sendOtp(phoneNumber: String) {
        try {
            val options = PhoneAuthOptions.newBuilder(mAuth)
                .setPhoneNumber("+91$phoneNumber") // Replace +91 with your country code
                .setTimeout(timeoutSeconds, TimeUnit.SECONDS)
                .setActivity(this)
                .setCallbacks(object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                    override fun onCodeSent(
                        verifId: String,
                        token: PhoneAuthProvider.ForceResendingToken
                    ) {
                        super.onCodeSent(verifId, token)
                        verificationId = verifId
                        Toast.makeText(applicationContext, "OTP sent successfully", Toast.LENGTH_SHORT).show()

                        // Navigate to verification activity
                        val intent = Intent(this@cont, verify::class.java)
                        intent.putExtra("verificationId", verificationId)
                        intent.putExtra("phoneNumber", phoneNumber)
                        startActivity(intent)
                    }

                    override fun onVerificationCompleted(p0: PhoneAuthCredential) {
                        // Not needed for sending OTP
                    }

                    override fun onVerificationFailed(p0: FirebaseException) {
                        Toast.makeText(applicationContext, "Phone Number could not be verified.", Toast.LENGTH_SHORT).show()
                    }
                })
                .build()

            PhoneAuthProvider.verifyPhoneNumber(options)
        } catch (e: FirebaseException) {
            Toast.makeText(applicationContext, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }
}

