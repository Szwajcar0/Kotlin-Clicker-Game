package com.example.projekt2yalla.ui.shop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.projekt2yalla.R
import com.example.projekt2yalla.databinding.FragmentShopBinding
import com.example.projekt2yalla.ui.model.*


class ShopFragment : Fragment() {
    private lateinit var binding: FragmentShopBinding
    var num: Int = 1
    var gold = GameEnigne.gold


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShopBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.blacksmithTablet.setOnClickListener{
            findNavController().navigate(R.id.action_shopFragment_to_blacksmithFragment)
        }
        binding.tvGold.text = GameEnigne.gold.toString()
        binding.tvExp.text = "Exp: "+ GameEnigne.exp.toString()
        binding.tvLvl.text = "Lvl: "+ GameEnigne.lvl.toString()
        binding.tvDmg.text = "Dmg: "+ StonePickaxe.dmg.toString()
        binding.tvCost.text = StonePickaxe.cost.toString()
        binding.tvName.text = StonePickaxe.name
        binding.btnBuy.setOnClickListener {
            if (num == 1 && GameEnigne.gold >= 150){
                UserPickaxe.dmg = StonePickaxe.dmg
                UserPickaxe.name = StonePickaxe.name
                GameEnigne.gold -= StonePickaxe.cost
                K2.dmg = StonePickaxe.dmg
                K2.name = StonePickaxe.name
                K2.czujka = 1
                binding.tvGold.text = GameEnigne.gold.toString()
                binding.buyanimation.animate().apply {
                    binding.buyanimation.animate().alpha(1f).setDuration(1000)
                }.withEndAction {
                    binding.buyanimation.animate().alpha(0f).setDuration(1000)
                }
            }
            else if(num == 1 && GameEnigne.gold < 150){
                binding.buyanimationF.animate().apply {
                    binding.buyanimationF.animate().alpha(1f).setDuration(1000)
                }.withEndAction {
                    binding.buyanimationF.animate().alpha(0f).setDuration(1000)
                }
            }
            else if(num == 2 && GameEnigne.gold >= 1000){
                UserPickaxe.dmg = GoldPickaxe.dmg
                UserPickaxe.name = GoldPickaxe.name
                GameEnigne.gold -= GoldPickaxe.cost
                K3.dmg = GoldPickaxe.dmg
                K3.name = GoldPickaxe.name
                K3.czujka = 1
                binding.tvGold.text = GameEnigne.gold.toString()
                binding.buyanimation.animate().apply {
                    binding.buyanimation.animate().alpha(1f).setDuration(1000)
                }.withEndAction {
                    binding.buyanimation.animate().alpha(0f).setDuration(1000)
                }
            }
            else if(num == 2 && GameEnigne.gold < 1000){
                binding.buyanimationF.animate().apply {
                    binding.buyanimationF.animate().alpha(1f).setDuration(1000)
                }.withEndAction {
                    binding.buyanimationF.animate().alpha(0f).setDuration(1000)
                }
            }
        }


        binding.arrowR.setOnClickListener {
            if (num == 2) {
                binding.arrowL.visibility = View.VISIBLE
                binding.arrowR.visibility = View.GONE
            } else {
                binding.arrowL.visibility = View.VISIBLE
                num += 1
                binding.pickaxe.animate().apply {
                    translationX(-1000f).setDuration(1000)
                    alpha(0f).setDuration(1000)
                }.withEndAction {
                    if (num == 1) {
                        binding.tvDmg.text = "Dmg: " + StonePickaxe.dmg.toString()
                        binding.tvCost.text = StonePickaxe.cost.toString()
                        binding.tvName.text = StonePickaxe.name
                        binding.pickaxe.setImageResource(R.drawable.pickaxe1)
                    } else if (num == 2) {
                        binding.tvDmg.text = "Dmg: " + GoldPickaxe.dmg.toString()
                        binding.tvCost.text = GoldPickaxe.cost.toString()
                        binding.tvName.text = GoldPickaxe.name
                        binding.pickaxe.setImageResource(R.drawable.pickaxesvg)

                    } else {
                        num == 0
                    }
                    binding.pickaxe.animate().apply {
                        translationX(0f).setDuration(1)
                    }.withEndAction {
                        binding.pickaxe.animate().alpha(1f).setDuration(1000)
                    }
                }
            }
        }
        binding.arrowL.setOnClickListener {
            if (num == 1) {
                binding.arrowL.visibility = View.GONE
                binding.arrowR.visibility = View.VISIBLE
            } else {
                binding.arrowR.visibility = View.VISIBLE
                num -= 1
                binding.pickaxe.animate().apply {
                    translationX(1000f).setDuration(1000)
                    alpha(0f).setDuration(1000)
                }.withEndAction {
                    if (num == 1) {
                        binding.tvDmg.text = "Dmg: " + StonePickaxe.dmg.toString()
                        binding.tvCost.text = StonePickaxe.cost.toString()
                        binding.tvName.text = StonePickaxe.name
                        binding.pickaxe.setImageResource(R.drawable.pickaxe1)
                    } else if (num == 2) {
                        binding.tvDmg.text = "Dmg: " + GoldPickaxe.dmg.toString()
                        binding.tvCost.text = GoldPickaxe.cost.toString()
                        binding.tvName.text = GoldPickaxe.name
                        binding.pickaxe.setImageResource(R.drawable.pickaxesvg)

                    } else {
                        num == 0
                    }
                    binding.pickaxe.animate().apply {
                        translationX(0f).setDuration(1)
                    }.withEndAction {
                        binding.pickaxe.animate().alpha(1f).setDuration(1000)
                    }
                }
            }
        }
    }


}
