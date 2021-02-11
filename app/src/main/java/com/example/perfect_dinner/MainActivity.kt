package com.example.perfect_dinner

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.perfect_dinner.firebase.FirebaseFunctionActivity
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse
import com.google.firebase.auth.FirebaseAuth

class MainActivity : FirebaseFunctionActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        // go back to original theme after splash screen
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createSignInIntent()
    }

}