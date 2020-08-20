package com.sibisoft.ejerciciorecycler.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class ClassroomViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    fun getRandomString(length: Int) : String {
        val allowedChars = ('A'..'Z') + ('a'..'z')
        return (1..length)
            .map { allowedChars.random() }
            .joinToString("")
    }

    private val studentMutableName = mutableListOf<Alumno>()
    val nameOfStudent = studentMutableName

    fun createStudent (nombre:String) {
        studentMutableName.add(Alumno(nombre))
    }

    private val studentMutableList = mutableListOf<Alumno>()
    val listOfStudent = studentMutableList

    fun completeListOfStudent(capacity: Int){
        //if(capacity==0) val newcapacity:Int = Random.nextInt(0,15)
        //else
            var count = 0
            do {
                listOfStudent.add(Alumno(getRandomString(Random.nextInt(0, 8))))
                count++

            }
            while (count <= capacity)

    }

    private val classroomMutable = mutableListOf <Grupo> ()
    val classroom = classroomMutable

    fun createClassroom (listOfStudent:MutableList<Alumno>) {
        classroom.add(Grupo(getRandomString(Random.nextInt(0, 10)),listOfStudent))
    }
}