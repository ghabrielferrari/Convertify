package com.gabrielferrari.convertify.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.gabrielferrari.convertify.databinding.FragmentFinanceBinding
import com.gabrielferrari.convertify.ui.viewModels.FinanceViewModel

class FinanceFragment : Fragment() {

    private var _binding: FragmentFinanceBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val financeViewModel =
            ViewModelProvider(this)[FinanceViewModel::class.java]

        _binding = FragmentFinanceBinding.inflate(
            inflater,
            container,
            false
        )
        val root: View = binding.root

        val textView: TextView = binding.textFinance
        financeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}