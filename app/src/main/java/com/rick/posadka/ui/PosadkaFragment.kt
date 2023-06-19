package com.rick.posadka.ui

import android.content.Context
import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.rick.posadka.R
import com.rick.posadka.databinding.FragmentPosadkaBinding
import com.rick.posadka.viewmodel.PosadkaViewModel
import com.rick.posadka.viewmodel.UiAction
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PosadkaFragment : Fragment() {

    private var _binding: FragmentPosadkaBinding? = null
    private val binding get() = _binding!!

    private val viewModel: PosadkaViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPosadkaBinding.inflate(inflater, container, false)

        binding.bindViews()

        return binding.root
    }

    private fun FragmentPosadkaBinding.bindViews() {

        // To listen for a switch's checked/unchecked state changes
        deviationSwitch.setOnCheckedChangeListener { switch, isChecked ->
            if (isChecked) {
                // The switch is enabled/checked
                switch.text = getString(R.string.hole)
            } else {
                // The switch is disabled
                switch.text = getString(R.string.shaft)
            }
        }

        searchPosadka.setOnEditorActionListener { _, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                // Perform search
                bindSearch()
                true
            } else {
                false
            }
        }

        size.setOnEditorActionListener { _, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_GO) {
                // Perform search
                Toast.makeText(requireContext(), "Lol, os is just trolling you", Toast.LENGTH_LONG).show()
                bindSearch()
                true
            } else {
                false
            }
        }

        size.setOnKeyListener { _, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                bindSearch()
                true
            } else {
                false
            }
        }

        searchButton.setOnClickListener {
            // Perform search
            bindSearch()
            // hide soft keyboard
            val imm = requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(it.windowToken, 0)
        }


    }

    private fun FragmentPosadkaBinding.bindSearch() {
        if (size.text.isNotEmpty() && searchPosadka.text.isNotEmpty()) {
            viewModel.onAction(
                if (deviationSwitch.isChecked) UiAction.SearchHole(
                    size.text.toString().toFloat(), searchPosadka.text.toString()
                ) else UiAction.SearchShaft(
                    size.text.toString().toFloat(), searchPosadka.text.toString()
                )
            )
        } else {
            Toast.makeText(requireContext(), "Заполните все поля", Toast.LENGTH_SHORT).show()
            highResult.text = getString(R.string.high_deviation)
            lowResult.text = getString(R.string.low_deviation)
        }

        if (deviationSwitch.isChecked) {
            viewModel.posadkaHole.observe(viewLifecycleOwner) {
                it?.let {
                    highResult.text = getString(R.string.estext, it.highDeviation.toString())
                    lowResult.text = getString(R.string.istext, it.lowDeviation.toString())
                    error.visibility = View.GONE
                } ?: run {
                    error.visibility = View.VISIBLE
                    highResult.text = getString(R.string.high_deviation)
                    lowResult.text = getString(R.string.low_deviation)
                }
            }
        } else {
            viewModel.posadkaShaft.observe(viewLifecycleOwner) {
                it?.let {
                    highResult.text = getString(R.string.estext, it.highDeviation.toString())
                    lowResult.text = getString(R.string.istext, it.lowDeviation.toString())
                    error.visibility = View.GONE
                } ?: run {
                    error.visibility = View.VISIBLE
                    highResult.text = getString(R.string.high_deviation)
                    lowResult.text = getString(R.string.low_deviation)
                }
            }
        }
    }

}


/*
*  Expected:
                 TableInfo{name='posadka_hole', columns={id=Column{name='id', type='INTEGER', affinity='3', notNull=true, primaryKeyPosition=1, defaultValue='undefined'}, , size=Column{name='size', type='INTEGER', affinity='3', notNull=true, primaryKeyPosition=0, defaultValue='undefined'}, prevsize=Column{name='prevsize', type='INTEGER', affinity='3', notNull=false, primaryKeyPosition=0, defaultValue='undefined'}, class=Column{name='class', type='TEXT', affinity='2', notNull=true, primaryKeyPosition=0, defaultValue='undefined'}, highdeviation=Column{name='highdeviation', type='INTEGER', affinity='3', notNull=true, primaryKeyPosition=0, defaultValue='undefined'}, lowdeviaton=Column{name='lowdeviaton', type='INTEGER', affinity='3', notNull=true, primaryKeyPosition=0, defaultValue='undefined'}}, foreignKeys=[], indices=[]}
                  Found:
                 TableInfo{name='posadka_hole', columns={id=Column{name='id', type='INTEGER', affinity='3', notNull=true, primaryKeyPosition=1, defaultValue='undefined'}, size=Column{name='size', type='INTEGER', affinity='3', notNull=true, primaryKeyPosition=0, defaultValue='undefined'}, prevsize=Column{name='prevsize', type='INTEGER', affinity='3', notNull=true, primaryKeyPosition=0, defaultValue='undefined'}, class=Column{name='class', type='TEXT', affinity='2', notNull=true, primaryKeyPosition=0, defaultValue='undefined'}, highdeviation=Column{name='highdeviation', type='INTEGER', affinity='3', notNull=true, primaryKeyPosition=0, defaultValue='undefined'}, lowdeviaton=Column{name='lowdeviaton', type='INTEGER', affinity='3', notNull=true, primaryKeyPosition=0, defaultValue='undefined'}}, foreignKeys=[], indices=[]}

* */