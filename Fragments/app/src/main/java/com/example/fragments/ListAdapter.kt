package com.example.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.LinearLayout
import android.widget.TextView
class ListAdapter(context: Context, arrayListDetails: ArrayList<Route>) : BaseAdapter(){

    private val layoutInflater: LayoutInflater
    private val arrayListDetails:ArrayList<Route>

    init {
        this.layoutInflater = LayoutInflater.from(context)
        this.arrayListDetails=arrayListDetails
    }

    override fun getCount(): Int {
        return arrayListDetails.size
    }

    override fun getItem(position: Int): Any {
        return arrayListDetails.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        val view: View?
        val postRowHolder: CommentRowHolder
        if (convertView == null) {
            view = this.layoutInflater.inflate(R.layout.activity_list_adapter, parent, false)
            postRowHolder = CommentRowHolder(view)
            if (view != null) {
                view.tag = postRowHolder
            }
        } else {
            view = convertView
            postRowHolder = view.tag as CommentRowHolder
        }

        postRowHolder.body.text = "Text: "+arrayListDetails.get(position).name
        return view
    }
}

private class CommentRowHolder(row: View?) {

    public val body: TextView
    public val linearLayout: LinearLayout

    init {

        this.body = row?.findViewById<TextView>(R.id.Name) as TextView
        this.linearLayout = row?.findViewById<LinearLayout>(R.id.Adapter) as LinearLayout
    }
}