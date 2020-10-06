package com.ontappoc.visitfeature

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class VisitSecondPageFragment : Fragment() {

    companion object {
        fun newInstance() = VisitSecondPageFragment()
    }

    private lateinit var viewModel: VisitSecondPageViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.visit_second_page_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(VisitSecondPageViewModel::class.java)
        // TODO: Use the ViewModel
    }

}