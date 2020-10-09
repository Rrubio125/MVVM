package com.sibisoft.ejerciciorecycler.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class ClassroomViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    private val classroomMutableLiveData = MutableLiveData<List<Group>>()
    val classroomLiveData = classroomMutableLiveData

    fun createRandomGroups() {
        val groups = mutableListOf<Group>()
        val numberOfGroup = Random.nextInt(1, 10)

        for (i in 1..numberOfGroup) {
            groups.add(createOneNewRandomGroup())
        }

        classroomMutableLiveData.postValue(groups)
    }

    private fun createOneNewRandomGroup(): Group {
        return Group(createRandomGroupNames(), createRandomStudentList(), createTeacher())
    }

    private fun createTeacher(): MutableList<Teacher> {
        val listOfTeachers = mutableListOf<Teacher>()
        val numberOfTeachers = 2
        for (i in 1..numberOfTeachers) {
            listOfTeachers.add(Teacher( "$i Teacher " + createRandomNames()))}
        return listOfTeachers
    }

    private fun createRandomStudentList(): MutableList<Student> {
        val listOfStudent = mutableListOf<Student>()
        val numberOfStudentInTheGroup = Random.nextInt(1, 15)

        for (i in 1..numberOfStudentInTheGroup) {
            listOfStudent.add(
                Student(
                    createRandomNames(),
                    createIdNumber(),
                    createGrades()
                )
            )
        }

        return listOfStudent
    }

    private fun createGrades(): Int {
        return Random.nextInt(0, 10)
    }

    private fun createIdNumber(): Int {
        return Random.nextInt(2014630000, 2014639999)
    }

    private fun createRandomNames(): String {
        val firstName = arrayOf(
            "Andrea ",
            "David ",
            "Joaquin ",
            "Martha ",
            "Juan ",
            "Jose ",
            "Manuel ",
            "Eduardo ",
            "Monste ",
            "Maria ",
            "Omar ",
            "Rodrigo ",
            "Romina ",
            "Lucero ",
            "Karla ",
            "Angeles ",
            "Cristina ",
            "Asuncion ",
            "Pilar ",
            "Teresa "
        )
        val secondName = arrayOf(
            "Gomez",
            "Guerrero",
            "Cardenas",
            "Rubio",
            "Hernandez",
            "Lopez",
            "Guitierrez",
            "Rodriguez",
            "Zamora",
            "Castillo",
            "Perez",
            "Castro",
            "Lee",
            "Martinez",
            "Rangel",
            "Moreno",
            "Becerra",
            "Tapia"
        )
        return firstName[Random.nextInt(0, 19)] + secondName[Random.nextInt(0, 17)]
    }

//    private fun generarNombreRandom() {
////        val allowedChars = ('A'..'Z') + ('a'..'z')
////        return (1..5)
////            .map { allowedChars.random() }
////            .joinToString("")
//        var generarNombresAleatorios : String[] (cantidad: Int)
//    }

    private fun createRandomGroupNames(): String {
        return "Grupo " + Random.nextInt(1, 10) + " de Android"
    }


}

