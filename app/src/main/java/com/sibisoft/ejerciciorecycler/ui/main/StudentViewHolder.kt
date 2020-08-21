package com.sibisoft.ejerciciorecycler.ui.main

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sibisoft.ejerciciorecycler.R
import kotlinx.android.synthetic.main.main_fragment.view.*

class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val name = itemView.findViewById<TextView>(R.id.student)
    private val boleta = itemView.findViewById<TextView>(R.id.boleta)
    private val calif = itemView.findViewById<TextView>(R.id.calif)


    fun bindStudent(alumno: Alumno){
        name.text = alumno.nombre
        boleta.text = alumno.boleta.toString()
        calif.text = alumno.calificacion.toString()
    }

}
