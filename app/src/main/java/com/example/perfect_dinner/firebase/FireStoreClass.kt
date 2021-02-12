package com.example.perfect_dinner.firebase

import android.util.Log
import com.example.perfect_dinner.activities.MainActivity
import com.example.perfect_dinner.models.User
import com.example.perfect_dinner.utils.Constants
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

 class FireStoreClass() {
    private val mFireStore = FirebaseFirestore.getInstance()
    private val db = Firebase.firestore

     fun registerUser(userInfo: User) {
        val docData = hashMapOf(
            "id" to userInfo.id,
            "uid" to userInfo.uid,
            "email" to userInfo.email,
            "name" to userInfo.name,
            "image" to userInfo.image,
            "fcmToken" to userInfo.fcmToken,
            "mobile" to userInfo.mobile
        )

        db.collection(Constants.USERS).document(userInfo.uid.toString())
            .set(docData, SetOptions.merge())
            .addOnSuccessListener {
                Log.d(
                    "fireStore",
                    "DocumentSnapshot successfully written! go on the right activity"
                )
                userRegisteredSuccess()
            }
            .addOnFailureListener { e -> Log.w("fireStore", "Error writing document", e) }

    }

    private fun userRegisteredSuccess() {

    }

    fun getCurrentUserId(): String {
        return FirebaseAuth.getInstance().currentUser!!.uid
    }
}