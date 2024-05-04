package com.gabrielferrari.convertify.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.gabrielferrari.convertify.databinding.FragmentMathBinding
import com.gabrielferrari.convertify.ui.viewModels.MathViewModel


class MathFragment : Fragment() {

    private var _binding: FragmentMathBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val mathViewModel =
            ViewModelProvider(this).get(MathViewModel::class.java)

        _binding = FragmentMathBinding.inflate(
            inflater,
            container,
            false
        )
        val root: View = binding.root

        val textView: TextView = binding.textMath
        mathViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}