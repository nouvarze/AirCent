package com.appcent.aircent.ui.flights

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.appcent.aircent.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FlightsFragment : Fragment() {

    companion object {
        fun newInstance() = FlightsFragment()
    }

    private val viewModel: FlightsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.flights_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
    }

}