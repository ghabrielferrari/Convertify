package com.gabrielferrari.convertify.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.gabrielferrari.convertify.databinding.FragmentUnitsBinding
import com.gabrielferrari.convertify.ui.activitiesButton.WeightActivityButton
import com.gabrielferrari.convertify.ui.viewModels.UnitsViewModel

class UnitsFragment : Fragment() {

    private var _binding: FragmentUnitsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val unitsViewModel =
            ViewModelProvider(this)[UnitsViewModel::class.java]

        _binding = FragmentUnitsBinding.inflate(
            inflater,
            container,
            false
        )
        val root: View = binding.root

        /*val textView: TextView = binding.textUnits
        unitsViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }*/
        val weightButton: Button = binding.btnWeight
        weightButton.setOnClickListener {
            startActivity(
                Intent(context, WeightActivityButton::class.java)
            )
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}