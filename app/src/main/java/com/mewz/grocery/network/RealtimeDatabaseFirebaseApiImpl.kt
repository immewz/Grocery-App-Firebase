package com.mewz.grocery.network

import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.mewz.grocery.data.vos.GroceryVO

object RealtimeDatabaseFirebaseApiImpl: FirebaseApi {

    private val database: DatabaseReference = Firebase.database.reference

    override fun getGroceries(
        onSuccess: (groceries: List<GroceryVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        database.child("groceries").addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val groceryList = arrayListOf<GroceryVO>()
                snapshot.children.forEach { dataSnapshot ->
                    dataSnapshot.getValue(GroceryVO::class.java)?.let {
                        groceryList.add(it)
                    }
                }
                onSuccess(groceryList)
            }

            override fun onCancelled(error: DatabaseError) {
                onFailure(error.message)
            }

        })
    }
}