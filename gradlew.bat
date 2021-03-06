package com.omersakalli.veripark.presentation.handshake

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.omersakalli.veripark.R
import com.omersakalli.veripark.databinding.HandshakeFragmentBinding
import com.omersakalli.veripark.domain.usecase.GetHandshakeUseCase

class HandshakeFragment() : Fragment() {

    private lateinit var binding: HandshakeFragmentBinding
    private lateinit var viewModel: HandshakeViewModel

    companion object {
        fun newInstance(foo: Int, bar: String) = HandshakeFragment().apply {
            arguments = bundleOf(
                FOO to foo,
                BAR to bar
            )
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.handshake_fragment,container,false)
        val view = binding.root
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HandshakeViewModel::class.java)
        // TODO: Use the ViewModel
    }

    fun getHandshake() = liveData {
        val handshake = getHandshakeUseCase.execute()
        Log.i("MYTAG",handshake!!.lifeTime)
        emit(handshake)
    }



}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    