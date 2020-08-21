package com.sibisoft.ejerciciorecycler.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.math.floor
import kotlin.random.Random

class ClassroomViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    private val classroomMutableLiveData = MutableLiveData<List<Grupo>>()
    val classroomLiveData = classroomMutableLiveData

    fun createRandomGroup() {
        val gruposAndroid = mutableListOf<Grupo>()
        val numeroDeGruposRandom = Random.nextInt(1, 10)

        for (i in 1..numeroDeGruposRandom) {
            gruposAndroid.add(generarGrupoRandom())
        }

        classroomMutableLiveData.postValue(gruposAndroid)
    }

    private fun generarGrupoRandom(): Grupo {
        return Grupo(generarNombreDeGrupoRandom(), generarListaDeAlumnoRandom(), generarProfesor())
    }

    private fun generarProfesor(): MutableList<Teacher> {
        val listaDeProfesores = mutableListOf<Teacher>()
        val numeroDeProfesores = 2
        for (i in 1..numeroDeProfesores) {
            listaDeProfesores.add(Teacher( "$i Teacher " + generarNombresAleatorios()))}
        return listaDeProfesores
    }

    private fun generarListaDeAlumnoRandom(): MutableList<Alumno> {
        val listaAlumnos = mutableListOf<Alumno>()
        val numeroDeAlumnosEnElGrupo = Random.nextInt(1, 15)

        for (i in 1..numeroDeAlumnosEnElGrupo) {
            listaAlumnos.add(
                Alumno(
                    generarNombresAleatorios(),
                    crearBoleta(),
                    generarCalificacion()
                )
            )
        }

        return listaAlumnos
    }

    private fun generarCalificacion(): Int {
        return Random.nextInt(0, 10)
    }

    private fun crearBoleta(): Int {
        return Random.nextInt(2014630000, 2014639999)
    }

    private fun generarNombresAleatorios(): String {
        val nombres = arrayOf(
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
        val apellidos = arrayOf(
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
        return nombres[Random.nextInt(0, 19)] + apellidos[Random.nextInt(0, 17)]
    }

//    private fun generarNombreRandom() {
////        val allowedChars = ('A'..'Z') + ('a'..'z')
////        return (1..5)
////            .map { allowedChars.random() }
////            .joinToString("")
//        var generarNombresAleatorios : String[] (cantidad: Int)
//    }

    private fun generarNombreDeGrupoRandom(): String {
        return "Grupo " + Random.nextInt(1, 10) + " de Android"
    }


}

