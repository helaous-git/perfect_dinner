package com.example.perfect_dinner

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        // go back to original theme after splash screen
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createSignInIntent()
    }

        private fun createSignInIntent() {
            // [START auth_fui_create_intent]
            // Choose authentication providers
            val providers = arrayListOf(
                AuthUI.IdpConfig.EmailBuilder().build(),  //marche
                // AuthUI.IdpConfig.PhoneBuilder().build(),
                AuthUI.IdpConfig.GoogleBuilder().build(),    // marche
                AuthUI.IdpConfig.FacebookBuilder().build(),  // marche
                AuthUI.IdpConfig.TwitterBuilder().build()
            )

            // Create and launch sign-in intent
            startActivityForResult(
                AuthUI.getInstance()
                    .createSignInIntentBuilder()
                    .setAvailableProviders(providers)
                    .setLogo(R.mipmap.ic_cooking_logo) // Set logo drawable
                    .setTheme(R.style.LoginTheme) // Set theme
                    .build(),
                RC_SIGN_IN
            )
            // [END auth_fui_create_intent]
        }

        // [START auth_fui_result]
        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)

            if (requestCode == RC_SIGN_IN) {
                val response = IdpResponse.fromResultIntent(data)

                if (resultCode == Activity.RESULT_OK) {
                    // Successfully signed in
                    val user = FirebaseAuth.getInstance().currentUser

                    Toast.makeText(this, "login success", Toast.LENGTH_SHORT).show()
                    Toast.makeText(this, user?.uid, Toast.LENGTH_SHORT).show()
                    // ...
                } else {
                    Toast.makeText(this, "failed login try again", Toast.LENGTH_SHORT).show()
                    createSignInIntent()
                    // Sign in failed. If response is null the user canceled the
                    // sign-in flow using the back button. Otherwise check
                    // response.getError().getErrorCode() and handle the error.
                    // ...
                }
            }
        }

        private fun signOut() {
            // [START auth_fui_signout]
            AuthUI.getInstance()
                .signOut(this)
                .addOnCompleteListener {
                    // ...
                }
            // [END auth_fui_signout]
        }

        private fun delete() {
            // [START auth_fui_delete]
            AuthUI.getInstance()
                .delete(this)
                .addOnCompleteListener {
                    // ...
                }
            // [END auth_fui_delete]
        }

        private fun themeAndLogo() {
            val providers = emptyList<AuthUI.IdpConfig>()

            // [START auth_fui_theme_logo]
            startActivityForResult(
                AuthUI.getInstance()
                    .createSignInIntentBuilder()
                    .setAvailableProviders(providers)
                    .setLogo(R.drawable.ic_cooking_logo_background) // Set logo drawable
                    .setTheme(R.style.AppTheme) // Set theme
                    .build(),
                RC_SIGN_IN
            )
            // [END auth_fui_theme_logo]
        }

        private fun privacyAndTerms() {
            val providers = emptyList<AuthUI.IdpConfig>()
            // [START auth_fui_pp_tos]
            startActivityForResult(
                AuthUI.getInstance()
                    .createSignInIntentBuilder()
                    .setAvailableProviders(providers)
                    .setTosAndPrivacyPolicyUrls(
                        "https://example.com/terms.html",
                        "https://example.com/privacy.html"
                    )
                    .build(),
                RC_SIGN_IN
            )
            // [END auth_fui_pp_tos]
        }

        // [END auth_fui_result]
        companion object {
            const val RC_SIGN_IN = 123
        }
    }