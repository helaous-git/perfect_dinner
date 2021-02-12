package com.example.perfect_dinner.activities

import android.os.Bundle
import com.example.perfect_dinner.R
import com.example.perfect_dinner.firebase.FireStoreClass
import com.example.perfect_dinner.firebase.FirebaseFunctionActivity

class MainActivity : FirebaseFunctionActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        // go back to original theme after splash screen
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createSignInIntent()
    }
}