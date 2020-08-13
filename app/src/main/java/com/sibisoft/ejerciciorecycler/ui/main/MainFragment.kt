package com.sibisoft.ejerciciorecycler.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.sibisoft.ejerciciorecycler.R
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    private var adapter : TestAdapter? = null

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

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
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onResume() {
        super.onResume()
        val gruposAndroid = mutableListOf<Grupo>()
        val listaAlumnos1 = mutableListOf<Alumno>()
        val listaAlumnos2 = mutableListOf<Alumno>()
        listaAlumnos1.add(Alumno("Emilio"))
        listaAlumnos1.add(Alumno("David"))
        listaAlumnos1.add(Alumno("Ricardo"))
        listaAlumnos1.add(Alumno("Eduardo"))
        listaAlumnos1.add(Alumno("Manolo"))
        listaAlumnos2.add(Alumno("Emilio2"))
        listaAlumnos2.add(Alumno("David2"))
        listaAlumnos2.add(Alumno("Ricardo2"))
        listaAlumnos2.add(Alumno("Eduardo2"))
        listaAlumnos2.add(Alumno("Manolo2"))

        gruposAndroid.add(Grupo("1er Grupo Android", listaAlumnos1))
        gruposAndroid.add(Grupo("2do Grupo Android", listaAlumnos2))
        adapter?.setData(gruposAndroid)
    }


}