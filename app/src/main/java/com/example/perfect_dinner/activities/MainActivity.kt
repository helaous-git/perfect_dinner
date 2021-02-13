package com.example.perfect_dinner.activities

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.perfect_dinner.R
import com.example.perfect_dinner.firebase.FirebaseFunctionActivity
import com.example.perfect_dinner.models.BetInfo
import com.example.perfect_dinner.recyclerviewadapter.ItemAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.menu_recycler_view.*

class MainActivity : FirebaseFunctionActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        // go back to original theme after splash screen
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createSignInIntent()
        listView()
    }

    private fun listView() {

        // Set the LayoutManager that this RecyclerView will use.
        rvItemsList.layoutManager = LinearLayoutManager(this)
        // Adapter class is initialized and list is passed in the param.
        val itemAdapter = ItemAdapter(this, getItemsList())
        // adapter instance is set to the recyclerview to inflate the items.
        rvItemsList.adapter = itemAdapter
    }

    private fun getItemsList(): ArrayList<BetInfo> {

        val list = ArrayList<BetInfo>()
        var betInfo= BetInfo("1","12 Jan","5","32","De la cuisine de chine","Monaco"," 20 €")

        list.add(betInfo)
        list.add(betInfo)
        list.add(betInfo)
        list.add(betInfo)
        list.add(betInfo)
        list.add(betInfo)


        return list
    }
}