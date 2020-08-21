package com.sibisoft.ejerciciorecycler.ui.main

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sibisoft.ejerciciorecycler.R

class GroupViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val textView = itemView.findViewById<TextView>(R.id.title_group)

    fun bind(group: Group) {
        textView.text = group.name
    }

}
