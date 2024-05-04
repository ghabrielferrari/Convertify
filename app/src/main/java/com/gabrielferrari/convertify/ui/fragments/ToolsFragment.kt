package com.gabrielferrari.convertify.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.gabrielferrari.convertify.databinding.FragmentToolsBinding
import com.gabrielferrari.convertify.ui.viewModels.ToolsViewModel

class ToolsFragment : Fragment() {

    private var _binding: FragmentToolsBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val toolsViewModel =
            ViewModelProvider(this)[ToolsViewModel::class.java]

        _binding = FragmentToolsBinding.inflate(
            inflater,
            container,
            false
        )
        val root: View = binding.root

        val textView: TextView = binding.textTools
        toolsViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}