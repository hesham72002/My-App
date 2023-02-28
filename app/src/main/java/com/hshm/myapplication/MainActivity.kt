package com.hshm.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.hshm.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val db = Firebase.firestore

        binding.button.setOnClickListener {
            var text1 = binding.editTextTextPersonName.text.toString()
            var text2 = binding.editTextTextPersonName2.text.toString()
            var text3 = binding.editTextTextPersonName3.text.toString()
            // Create a new user with a first and last name
            val user = hashMapOf(
                "text1" to text1,
                "text2" to text2,
                "text3" to text3
            )

            db.collection("users")
                .add(user)
                .addOnSuccessListener { documentReference ->
                    Toast.makeText(this, "secs", Toast.LENGTH_SHORT).show()
                    Log.d("hshm", "DocumentSnapshot added with ID: ${documentReference.id}")
                }
                .addOnFailureListener { e ->
                    Toast.makeText(this, "no secs", Toast.LENGTH_SHORT).show()
                    Log.w("hshm", "Error adding document", e)
                }
        }

    }
}