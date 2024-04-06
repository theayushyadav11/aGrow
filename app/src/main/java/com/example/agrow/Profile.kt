//package com.example.agrow
//
//import android.app.Activity
//import android.app.DatePickerDialog
//import android.content.Intent
//import android.graphics.Bitmap
//import android.os.Bundle
//import android.widget.*
//import androidx.activity.enableEdgeToEdge
//import androidx.appcompat.app.AppCompatActivity
//import androidx.core.view.ViewCompat
//import androidx.core.view.WindowInsetsCompat
//import com.google.firebase.firestore.FirebaseFirestore
//import java.util.Calendar
//
//class Profile : AppCompatActivity() {
//    private lateinit var profileName: EditText
//    private lateinit var dob: EditText
//    private lateinit var address: EditText
//    private lateinit var phoneNumber: EditText
//    private lateinit var progressBar: ProgressBar
//    private lateinit var radioGroupRegisterGender: RadioGroup
//    private lateinit var radioButtonRegisterGenderSelected: RadioButton
//    private lateinit var profileImageView: ImageView
//    private val REQUEST_IMAGE_CAPTURE = 1
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContentView(R.layout.activity_profile)
//        supportActionBar?.title = "User com.example.agrow.Profile"
//
//        profileName = findViewById(R.id.editView_profile_Name)
//        dob = findViewById(R.id.editView_dob)
//        address = findViewById(R.id.editView_address)
//        phoneNumber = findViewById(R.id.etPhone)
//        progressBar = findViewById(R.id.progressBar)
//        radioGroupRegisterGender = findViewById(R.id.radio_group_register_gender)
//        profileImageView = findViewById(R.id.profile_image)
//
//        // Set padding for system bars
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
//
//        // Date of birth picker
//        dob.setOnClickListener {
//            val calendar = Calendar.getInstance()
//            val day = calendar.get(Calendar.DAY_OF_MONTH)
//            val month = calendar.get(Calendar.MONTH)
//            val year = calendar.get(Calendar.YEAR)
//
//            val datePickerDialog = DatePickerDialog(
//                this,
//                DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
//                    dob.setText("$dayOfMonth/${month + 1}/$year")
//                },
//                year,
//                month,
//                day
//            )
//            datePickerDialog.show()
//        }
//
//        // Button to capture or upload profile picture
//        val changePictureButton: Button = findViewById(R.id.button_change_picture)
//        changePictureButton.setOnClickListener {
//            dispatchTakePictureIntent()
//        }
//
//        // Button to update profile
//        val updateProfileButton: Button = findViewById(R.id.Button_update_profile)
//        updateProfileButton.setOnClickListener {
//            updateProfile()
//        }
//    }
//
//    // Handle the result of taking a picture using the camera
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
//            val imageBitmap = data?.extras?.get("data") as Bitmap
//            profileImageView.setImageBitmap(imageBitmap)
//            // Now you can save the imageBitmap to storage or upload it to a server
//        }
//    }
//
//    // Create an intent to take a picture using the device's camera
//    private fun dispatchTakePictureIntent() {
//        Intent(Intent.ACTION_PICK).also { takePictureIntent ->
//            takePictureIntent.type = "image/*"
//            val mimeType = arrayOf("image/jpeg", "image/png")
//            takePictureIntent.putExtra(Intent.EXTRA_MIME_TYPES, mimeType)
//            takePictureIntent.resolveActivity(packageManager)?.also {
//                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
//            }
//        }
//    }
//    private fun updateProfile() {
//        val textFullName = profileName.text.toString()
//        val textDob = dob.text.toString()
//        val textAddress = address.text.toString()
//        val textPhone = phoneNumber.text.toString()
//
//        // Validate input fields
//        if (textFullName.isEmpty()) {
//            profileName.error = "Full Name is required!"
//            profileName.requestFocus()
//            return
//        }
//        if (textDob.isEmpty()) {
//            dob.error = "DOB is required!"
//            dob.requestFocus()
//            return
//        }
//        if (textAddress.isEmpty()) {
//            Toast.makeText(this, "Please enter your address.", Toast.LENGTH_LONG).show()
//            return
//        }
//
//        // Save profile information to database
//        saveProfileToDatabase(textFullName, textDob, textAddress, textPhone)
//    }
//
//    private fun saveProfileToDatabase(fullName: String, dob: String, address: String, phone: String) {
//        // Implement database saving logic here
//        // You can use Firebase Realtime Database, Firestore, or any other database of your choice
//        // Example:
//        val user = hashMapOf(
//            "fullName" to fullName,
//            "dob" to dob,
//            "address" to address,
//            "phone" to phone
//        )
//
//        private fun saveProfileToDatabase(fullName: String, dob: String, address: String, phone: String) {
//            // Access Firebase Firestore instance
//            val db = FirebaseFirestore.getInstance()
//
//            // Create a new document with a generated ID
//            val user = hashMapOf(
//                "fullName" to fullName,
//                "dob" to dob,
//                "address" to address,
//                "phone" to phone
//            )
//
//            // Add a new document with a generated ID
//            db.collection("users")
//                .add(user)
//                .addOnSuccessListener { documentReference ->
//                    // Document added successfully
//                    Toast.makeText(this, "com.example.agrow.Profile updated successfully!", Toast.LENGTH_SHORT).show()
//                }
//                .addOnFailureListener { e ->
//                    // Error adding document
//                    Toast.makeText(this, "Error updating profile: ${e.message}", Toast.LENGTH_SHORT).show()
//                }
//        }
//    }
//}