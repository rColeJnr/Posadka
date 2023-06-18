package com.rick.posadka.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.rick.posadka.databinding.FragmentPosadkaBinding
import com.rick.posadka.viewmodel.PosadkaViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PosadkaFragment: Fragment() {

    private var _binding : FragmentPosadkaBinding? = null
    private val binding get() = _binding!!

    private val viewModel: PosadkaViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPosadkaBinding.inflate(inflater, container, false)

        viewModel.getPosadkaHole(3, "D6")
        viewModel.getPosadkaShaft(30, "A10")

    viewModel.posadkaHole.observe(viewLifecycleOwner, {
        Log.i("posadka", "here hole ${it}")
    })

        viewModel.posadkaShaft.observe(viewLifecycleOwner, {
        Log.i("posadka", "here shaft ${it}")
        })

        binding.bindViews()

        return binding.root
    }

    private fun FragmentPosadkaBinding.bindViews() {

    }

}