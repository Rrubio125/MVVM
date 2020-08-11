package com.sibisoft.ejerciciorecycler.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sibisoft.ejerciciorecycler.R
import java.security.AccessControlContext

class TestAdapter(context: Context) : RecyclerView.Adapter<ItemViewHolder>() {

    private val layoutInflater = LayoutInflater.from(context)
    private var itemsList = listOf<Alumno>()

    fun setData(list: List<Alumno>){
        this.itemsList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = layoutInflater.inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val alumno = itemsList[position]
        holder.bind(alumno)
    }

}
