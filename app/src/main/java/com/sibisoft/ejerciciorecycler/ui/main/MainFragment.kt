package com.sibisoft.ejerciciorecycler.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.sibisoft.ejerciciorecycler.R
import kotlinx.android.synthetic.main.main_fragment.*
import kotlin.random.Random

class MainFragment : Fragment() {

    private var adapter : TestAdapter? = null

    companion object {
        fun newInstance() = MainFragment()
    }

    private val studentObserver = Observer<Alumno>{

    }

    private lateinit var viewModel: ClassroomViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = TestAdapter(view.context)
        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(view.context)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ClassroomViewModel::class.java)
        // TODO: Use the ViewModel
        val listOfStudent1 = viewModel.completeListOfStudent(Random.nextInt(0, 10))
        val groupOfStudent1 = viewModel.createClassroom(listOfStudent1)
        val list2 = viewModel.completeListOfStudent()
        val grupoAndroid =

    }

    override fun onResume() {
        super.onResume()
        viewModel.createStudent("Ricardo")
        val gruposAndroid = mutableListOf<Grupo>()
        val listaAlumnos1 = mutableListOf<Alumno>()
        val listaAlumnos2 = mutableListOf<Alumno>()
        gruposAndroid.add(Grupo("1er Grupo Android", listaAlumnos1))
        gruposAndroid.add(Grupo("2do Grupo Android", listaAlumnos2))
        adapter?.setData(gruposAndroid)
    }


}