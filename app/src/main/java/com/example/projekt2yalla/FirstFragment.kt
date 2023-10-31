package com.example.projekt2yalla

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.projekt2yalla.databinding.FragmentFirstBinding
import kotlinx.coroutines.delay

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener{
            val intent = Intent(requireContext(), MainActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()

        binding.textviewFirst.animate().apply {
            translationY(-1000f).setDuration(0)
            alpha(0f).setDuration(0)
        }.withEndAction {
            binding.textviewFirst.animate().apply {
                translationY(0f).setDuration(1000)
                alpha(1f).setDuration(2500)
            }
        }
        binding.buttonFirst.animate().apply {
            alpha(1f).setDuration(1000)
            setStartDelay(2000)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}