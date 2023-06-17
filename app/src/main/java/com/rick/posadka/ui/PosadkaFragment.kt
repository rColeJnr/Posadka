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

        viewModel.getPosadkaHole(35, "D6")
        viewModel.getPosadkaShaft(35, "H6")


        Log.i("posadka", "here hole ${viewModel.posadkaHole}")
        Log.i("posadka", "here shaft ${viewModel.posadkaShaft}")

        binding.bindViews()

        return binding.root
    }

    private fun FragmentPosadkaBinding.bindViews() {

    }

}