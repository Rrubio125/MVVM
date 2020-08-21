package com.sibisoft.ejerciciorecycler.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
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
        return Grupo(generarNombreDeGrupoRandom(), generarListaDeAlumnoRandom())
    }

    private fun generarListaDeAlumnoRandom(): MutableList<Alumno> {
        val listaAlumnos = mutableListOf<Alumno>()
        val numeroDeAlumnosEnElGrupo = Random.nextInt(1, 15)

        for (i in 1..numeroDeAlumnosEnElGrupo) {
            listaAlumnos.add(Alumno(generarNombreDeAlumnoRandom()))
        }

        return listaAlumnos
    }

    private fun generarNombreDeAlumnoRandom(): String {
        val allowedChars = ('A'..'Z') + ('a'..'z')
        return (1..5)
            .map { allowedChars.random() }
            .joinToString("")
    }

    private fun generarNombreDeGrupoRandom(): String {
        return "Grupo " + Random.nextInt(1, 10) + "de Android"
    }


}

