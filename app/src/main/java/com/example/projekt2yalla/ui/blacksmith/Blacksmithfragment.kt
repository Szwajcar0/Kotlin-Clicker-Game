package com.example.projekt2yalla.ui.blacksmith

import android.opengl.Visibility
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.projekt2yalla.R
import com.example.projekt2yalla.databinding.FragmentBlacksmithBinding
import com.example.projekt2yalla.ui.model.GameEnigne

class BlacksmithFragment : Fragment() {
    private lateinit var binding: FragmentBlacksmithBinding
    private var firstRun = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBlacksmithBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tablethome.setOnClickListener {
            findNavController().navigate(R.id.action_blacksmithFragment_to_navigation_home)
        }
        binding.tabletShop.setOnClickListener {
            findNavController().navigate(R.id.action_blacksmithFragment_to_shopFragment)
        }
        binding.chmurka.setOnClickListener{
            firstRun = false
            binding.chmurka.animate().apply {
                alpha(0f)
                binding.tekstChmurki.animate().apply {
                    alpha(0f)
                }
            }
        }
        binding.tvGold.text = GameEnigne.gold.toString()
        binding.tvExp.text = "Exp: "+ GameEnigne.exp.toString()
        binding.tvLvl.text = "Lvl: "+ GameEnigne.lvl.toString()
    }

    override fun onResume() {
        super.onResume()

        binding.blacksmith.animate().apply {
            translationX(-100f).setDuration(0)
        }.withEndAction {
            binding.blacksmith.animate().apply {
                alpha(1f).setDuration(1500)
                translationX(0f).setDuration(1500)
            }
        }
        if (firstRun == true) {
            firstRun = false
            binding.chmurka.animate().apply {
                translationX(1000f).setDuration(0)
            }.withEndAction {
                binding.chmurka.animate().apply {
                    alpha(0.9f).setDuration(1500)
                    translationX(0f).setDuration(1500)
                }
            }
            binding.tekstChmurki.animate().apply {
                translationX(1000f).setDuration(0)
            }.withEndAction {
                binding.tekstChmurki.animate().apply {
                    alpha(1f).setDuration(1500)
                    translationX(0f).setDuration(1500)
                }
            }
        } else {
            firstRun = false
        }

    }

}