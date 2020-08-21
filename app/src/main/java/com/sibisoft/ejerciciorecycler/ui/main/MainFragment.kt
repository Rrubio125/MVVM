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

class MainFragment : Fragment() {

    private var adapter: TestAdapter? = null
    private lateinit var viewModel: ClassroomViewModel

    private val classroomObserver = Observer<List<Group>> {
        adapter?.setData(it)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = TestAdapter(view.context)
        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(view.context)
        btn_random.setOnClickListener {
            viewModel.createRandomGroups()
        }

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ClassroomViewModel::class.java)
        // TODO: Use the ViewModel
        viewModel.classroomLiveData.observe(viewLifecycleOwner, classroomObserver)

    }


    companion object {
        fun newInstance() = MainFragment()
    }

}