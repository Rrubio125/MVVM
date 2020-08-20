package com.sibisoft.ejerciciorecycler.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sibisoft.ejerciciorecycler.R
import java.security.AccessControlContext

class TestAdapter(context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val layoutInflater = LayoutInflater.from(context)
    private var itemsList = listOf<Grupo>()

    fun setData(list: List<Grupo>) {
        this.itemsList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = layoutInflater.inflate(R.layout.group_layout, parent, false)
        return GroupViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        var count = 0
        itemsList.forEach {
           if(position == count) return GROUP_TYPE
            count++
            it.listaAlumno.forEach {
                if(position==count) return STUDENT_YPE
            }
        }

    }

    override fun getItemCount(): Int {
        var count = 0
        itemsList.forEach {
            count++
            it.listaAlumno.forEach {
                count++
            }
        }
        return count
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val alumno = itemsList[position]
        holder.bind(alumno)

    }

    companion object {

        const val GROUP_TYPE = 1
        const val STUDENT_YPE = 2

    }

}
