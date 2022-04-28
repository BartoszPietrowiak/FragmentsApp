package com.example.fragments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView

class ListFragment : AppCompatActivity() {
    lateinit var listview_route: ListView
    var routelist: ArrayList<Route> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_fragment)
        val extras = intent.extras
        routelist = extras!!.getSerializable("userList") as ArrayList<Route>
        listview_route = findViewById<ListView>(R.id.lista) as ListView
        listview_route.adapter =
            ListAdapter(this, routelist )
        listview_route.setOnItemClickListener(AdapterView.OnItemClickListener { parent, view, position, id ->
            val selectedItem = parent.getItemAtPosition(position) as Route
            val intent = Intent(this, DetailFragment::class.java)
            intent.putExtra("route", selectedItem)
            startActivity(intent)
            this.finish()
        })
    }

}