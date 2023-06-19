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
class PosadkaFragment : Fragment() {

    private var _binding: FragmentPosadkaBinding? = null
    private val binding get() = _binding!!

    private val viewModel: PosadkaViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPosadkaBinding.inflate(inflater, container, false)

        viewModel.getPosadkaHole(43, "h7")
        viewModel.getPosadkaShaft(23, "s7")

        viewModel.posadkaHole.observe(viewLifecycleOwner, {
            Log.i("posadka", "here this hole ${it}")
        })

        viewModel.posadkaShaft.observe(viewLifecycleOwner, {
            Log.i("posadka", "here this shaft ${it}")
        })

        binding.bindViews()

        return binding.root
    }

    private fun FragmentPosadkaBinding.bindViews() {

    }

}


/*
*  Expected:
                 TableInfo{name='posadka_hole', columns={id=Column{name='id', type='INTEGER', affinity='3', notNull=true, primaryKeyPosition=1, defaultValue='undefined'}, , size=Column{name='size', type='INTEGER', affinity='3', notNull=true, primaryKeyPosition=0, defaultValue='undefined'}, prevsize=Column{name='prevsize', type='INTEGER', affinity='3', notNull=false, primaryKeyPosition=0, defaultValue='undefined'}, class=Column{name='class', type='TEXT', affinity='2', notNull=true, primaryKeyPosition=0, defaultValue='undefined'}, highdeviation=Column{name='highdeviation', type='INTEGER', affinity='3', notNull=true, primaryKeyPosition=0, defaultValue='undefined'}, lowdeviaton=Column{name='lowdeviaton', type='INTEGER', affinity='3', notNull=true, primaryKeyPosition=0, defaultValue='undefined'}}, foreignKeys=[], indices=[]}
                  Found:
                 TableInfo{name='posadka_hole', columns={id=Column{name='id', type='INTEGER', affinity='3', notNull=true, primaryKeyPosition=1, defaultValue='undefined'}, size=Column{name='size', type='INTEGER', affinity='3', notNull=true, primaryKeyPosition=0, defaultValue='undefined'}, prevsize=Column{name='prevsize', type='INTEGER', affinity='3', notNull=true, primaryKeyPosition=0, defaultValue='undefined'}, class=Column{name='class', type='TEXT', affinity='2', notNull=true, primaryKeyPosition=0, defaultValue='undefined'}, highdeviation=Column{name='highdeviation', type='INTEGER', affinity='3', notNull=true, primaryKeyPosition=0, defaultValue='undefined'}, lowdeviaton=Column{name='lowdeviaton', type='INTEGER', affinity='3', notNull=true, primaryKeyPosition=0, defaultValue='undefined'}}, foreignKeys=[], indices=[]}

* */