package com.sibisoft.ejerciciorecycler.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class ClassroomViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    private val classroomMutableLiveData = MutableLiveData<List<Grupo>>()
    val classroomLiveData = classroomMutableLiveData


//    fun createStudent(nombre: String) {
//        studentMutableName.add(Alumno(nombre))
//    }
//
//    fun completeListOfStudent(capacity: Int): {
//        //if(capacity==0) val newcapacity:Int = Random.nextInt(0,15)
//        //else
//        var count = 0
//        do {
//            listOfStudent.add(Alumno(getRandomString(Random.nextInt(4, 8))))
//            count++
//
//        } while (count <= capacity)
//
//    }
//
//    fun createClassroom(listOfStudent: MutableList<Alumno>) {
//        classroom.add(Grupo(getRandomString(Random.nextInt(4, 10)), listOfStudent))
//    }

    fun getRandomString(length: Int): String {
        val allowedChars = ('A'..'Z') + ('a'..'z')
        return (1..length)
            .map { allowedChars.random() }
            .joinToString("")
    }

    fun createRandomGroup() {
        val gruposAndroid = mutableListOf<Grupo>()
        val listaAlumnos1 = mutableListOf<Alumno>()
        val listaAlumnos2 = mutableListOf<Alumno>()
        listaAlumnos1.add(Alumno("Emilio"))
        listaAlumnos2.add(Alumno("Ricardo"))
        gruposAndroid.add(Grupo("1er Grupo Android", listaAlumnos1))
        gruposAndroid.add(Grupo("2do Grupo Android", listaAlumnos2))
        classroomMutableLiveData.postValue(gruposAndroid)
    }
}

