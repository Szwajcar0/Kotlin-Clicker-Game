package com.example.projekt2yalla.ui.home

import android.media.Image
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.projekt2yalla.R
import com.example.projekt2yalla.databinding.FragmentGameBinding
import com.example.projekt2yalla.databinding.FragmentHomeBinding
import com.example.projekt2yalla.ui.dashboard.GameFragment
import com.example.projekt2yalla.ui.model.*


class HomeFragment : Fragment(R.layout.fragment_home) {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private var user: User? = null

    private lateinit var inventoryContainer: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {bundle ->

            user = bundle.getSerializable("user" ) as User
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.table.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_home_to_blacksmithFragment)
        }
        if (UserPickaxe.id == 1){
            binding.kilof.setImageResource(R.drawable.woodenpickaxe)
        }else if(UserPickaxe.id == 2){
            binding.kilof.setImageResource(R.drawable.pickaxe1)
        }else if(UserPickaxe.id == 3){
            binding.kilof.setImageResource(R.drawable.pickaxesvg)
        }else{}


        binding.ramka4.setOnClickListener {
            binding.menuk.visibility = View.VISIBLE
            binding.kilof.alpha = 0f
            if(K2.czujka == 1) {
                binding.k2.setImageResource(R.drawable.pickaxe1)
            }
            else{

            }
            if(K3.czujka == 1){
                binding.k3.setImageResource(R.drawable.pickaxesvg)
            }else {

            }
        }
        binding.xprzycisk.setOnClickListener {
            binding.menuk.visibility = View.GONE
            binding.kilof.alpha = 1f
        }
        binding.k1.setOnClickListener {
            binding.kilof.setImageResource(R.drawable.woodenpickaxe)
            binding.menuk.visibility = View.GONE
            binding.kilof.alpha = 1f
            UserPickaxe.id = 1
            UserPickaxe.dmg = WoodenPickaxe.dmg
            UserPickaxe.name = WoodenPickaxe.name
        }
        binding.k2.setOnClickListener {

            binding.kilof.setImageResource(R.drawable.pickaxe1)
            binding.menuk.visibility = View.GONE
            binding.kilof.alpha = 1f
            UserPickaxe.id = 2
            UserPickaxe.dmg = K2.dmg
            UserPickaxe.name = K2.name
        }
        binding.k3.setOnClickListener {
            binding.kilof.setImageResource(R.drawable.pickaxesvg)
            binding.menuk.visibility = View.GONE
            binding.kilof.alpha = 1f
            UserPickaxe.id = 3
            UserPickaxe.dmg = K3.dmg
            UserPickaxe.name = K3.name
        }






        binding.tvGold.text = GameEnigne.gold.toString()
        binding.tvExp.text = "Exp: "+GameEnigne.exp.toString()
        binding.tvLvl.text = "Lvl: "+GameEnigne.lvl.toString()
//        binding.tvGold.text = user?.gold.toString()
//        binding.tvExp.text = user?.exp.toString()
//        binding.tvLvl.text = user?.lvl.toString()
    }
}