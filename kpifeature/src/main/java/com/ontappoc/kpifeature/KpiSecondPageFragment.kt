package com.ontappoc.kpifeature

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.kpi_second_page_fragment.*

class KpiSecondPageFragment : Fragment() {

    companion object {
        fun newInstance() = KpiSecondPageFragment()
    }

    private lateinit var viewModel: KpiSecondPageViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.kpi_second_page_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        visitFirstPage.setOnClickListener {
            findNavController().navigate(R.id.action_kpiSecondPageFragment_to_VisitFirstPageFragment)
        }

        visitSecondPage.setOnClickListener {
            findNavController().navigate(R.id.action_kpiSecondPageFragment_to_VisitSecondPageFragment)
        }

        visitModule.setOnClickListener {
            findNavController().navigate(R.id.action_kpiSecondPageFragment_to_visit_nav_graph)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(KpiSecondPageViewModel::class.java)
        // TODO: Use the ViewModel
    }

}