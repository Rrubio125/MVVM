package com.sibisoft.ejerciciorecycler.ui.main

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sibisoft.ejerciciorecycler.R
import kotlinx.android.synthetic.main.main_fragment.view.*

class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val textView = itemView.findViewById<TextView>(R.id.student)

    fun bindStudent(alumno: Alumno){
        textView.text = alumno.nombre

    }

}
