package com.sibisoft.ejerciciorecycler.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sibisoft.ejerciciorecycler.R

class TestAdapter(context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val layoutInflater = LayoutInflater.from(context)
    private var itemsList = listOf<Group>()

    fun setData(list: List<Group>) {
        this.itemsList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            GROUP_TYPE -> {
                val view = layoutInflater.inflate(R.layout.group_layout, parent, false)
                GroupViewHolder(view)
            }
            STUDENT_TYPE -> {
                val view = layoutInflater.inflate(R.layout.alumn_layout, parent, false)
                StudentViewHolder(view)
            }
            TEACHER_TYPE -> {
                val view = layoutInflater.inflate(R.layout.teacher_layout, parent, false)
                TeacherViewHolder(view)
            }
            else -> throw IndexOutOfBoundsException()
        }
    }

    override fun getItemViewType(position: Int): Int {
        var count = 0                                           // count = 0
        itemsList.forEach { grupo ->                            // position = 0
            if (position == count) return GROUP_TYPE            // grupo = 0
            count++
            repeat(grupo.teacher.size) {
                if (position==count) return TEACHER_TYPE
                count++
            }
            grupo.listOfStudent.forEach { alumno ->               // alumno = 0
                if(position == count) return STUDENT_TYPE
                count++
            }

        }
        throw IndexOutOfBoundsException()
    }

    override fun getItemCount(): Int {
        var count = 0
        itemsList.forEach { group ->
            count++
            repeat(group.teacher.size) {
                count++
            }
            group.listOfStudent.forEach { student ->
                count++
            }
        }
        return count
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItemInList(position)
        when (holder) {
            is GroupViewHolder -> {
                holder.bind(item as Group)
            }
            is StudentViewHolder -> {
                holder.bindStudent(item as Student)
            }
            is TeacherViewHolder -> {
                holder.bindTeacher(item as Teacher)
            }
        }
    }

    private fun getItemInList(position: Int) : Any {
        var count = 0
        itemsList.forEach { grupo ->
            if (position == count) return grupo
            count++
            grupo.teacher.forEach{
                if (position == count) return it
                count++
            }
            grupo.listOfStudent.forEach { alumno ->
                if(position == count) return alumno
                count++
            }
        }
        throw IndexOutOfBoundsException()
    }

    companion object {
        const val GROUP_TYPE = 1
        const val STUDENT_TYPE = 2
        const val TEACHER_TYPE = 3
    }

}