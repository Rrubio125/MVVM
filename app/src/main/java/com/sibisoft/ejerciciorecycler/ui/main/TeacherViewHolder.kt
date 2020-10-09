package com.sibisoft.ejerciciorecycler.ui.main

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sibisoft.ejerciciorecycler.R

class TeacherViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val textView = itemView.findViewById<TextView>(R.id.teacher_name)
    private val picture = itemView.findViewById<ImageView>(R.id.picture)

    fun bindTeacher(teacher: Teacher) {
        textView.text = teacher.name
        picture.setImageResource()
    }
}
