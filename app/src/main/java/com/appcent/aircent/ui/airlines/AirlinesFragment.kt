package com.appcent.aircent.ui.airlines

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import com.appcent.aircent.R
import com.appcent.aircent.databinding.FragmentAirlinesBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChangedBy
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AirlinesFragment : Fragment() {

    private val airlinesViewModel: AirlinesViewModel by viewModels()
    private lateinit var binding: FragmentAirlinesBinding
    private val adapter = AirlinesListAdapter()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_airlines,container,false)

        initAdapter()
        initRecyclerview()

        return binding.root
    }

    private fun initAdapter() {
        binding.airlinesRecyclerview.adapter = adapter
        // Scroll to top when the list is refreshed from network.
        lifecycleScope.launch {
            adapter.loadStateFlow
                // Only emit when REFRESH LoadState for RemoteMediator changes.
                .distinctUntilChangedBy { it.refresh }
                // Only react to cases where Remote REFRESH completes i.e., NotLoading.
                .filter { it.refresh is LoadState.NotLoading }
                .collect { binding.airlinesRecyclerview.scrollToPosition(0) }
        }
    }

    private fun initRecyclerview(){
        lifecycleScope.launch {
            airlinesViewModel.getAirlines().collectLatest {
                adapter.submitData(it)
            }
        }
    }
}