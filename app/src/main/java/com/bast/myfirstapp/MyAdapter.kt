package com.bast.myfirstapp

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val MyData: List<Char>): RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class ViewHolder(inflater: LayoutInflater, parent: ViewGroup): RecyclerView.ViewHolder(inflater.inflate(R.layout.list_item, parent, false)) {
        var titleView: TextView? = null

        init {
            titleView = itemView.findViewById(R.id.list_title)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
        return ViewHolder(view, parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.titleView?.text = MyData[position].toString().toUpperCase()
    }

    override fun getItemCount(): Int = MyData.size
}