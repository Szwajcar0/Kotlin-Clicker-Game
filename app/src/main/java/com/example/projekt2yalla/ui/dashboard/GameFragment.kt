package com.example.projekt2yalla.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.projekt2yalla.R
import com.example.projekt2yalla.databinding.FragmentGameBinding
import com.example.projekt2yalla.ui.model.GameEnigne
import com.example.projekt2yalla.ui.model.Kamien
import com.example.projekt2yalla.ui.model.UserPickaxe
import kotlin.random.Random

class GameFragment : Fragment(R.layout.fragment_game) {

    private lateinit var binding: FragmentGameBinding
    //dane
    var gold = GameEnigne.gold
    var cash = Kamien.cash
    var iexp = Kamien.iexp
    var hp = Kamien.hp
    var dmg = UserPickaxe.dmg
    var exp = GameEnigne.exp
    var lvl = GameEnigne.lvl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvExp.text = "Exp: $exp"
        binding.tvLvl.text = "Lvl: $lvl"
        binding.tvGold.text = "$gold"
        binding.tvHp.text = "Hp: $hp"
        binding.rock.setOnClickListener {

            if (hp >= 1) {
                GameEnigne.gold = gold
                GameEnigne.exp = exp
                GameEnigne.lvl = lvl
                Kamien.cash = cash
                Kamien.iexp = iexp
                hp -= dmg
                GameEnigne.hpfw = hp
                binding.tvExp.text = "Exp: $exp"
                binding.tvLvl.text = "Lvl: $lvl"
                binding.tvGold.text = "$gold"
                binding.tvHp.text = "Hp: $hp"
                binding.rock.animate().apply {
                    rotationY(20f).setDuration(100)
                }.withEndAction() {
                    binding.rock.animate().apply {
                        rotationY(-20f).setDuration(100)
                    }.withEndAction() {
                        binding.rock.animate().apply {
                            rotationY(0f).setDuration(100)
                        }
                    }
                }
            } else if (hp <= 1) {
                gold += cash
                exp += iexp
                hp = Kamien.hp
                GameEnigne.gold = gold
                GameEnigne.exp = exp
                GameEnigne.lvl = lvl
                binding.tvHp.text = "Hp: $hp"
                binding.tvGold.text = "$gold"
                binding.tvExp.text = "Exp: $exp"
                binding.tvLvl.text = "Lvl: $lvl"
                binding.goldgain.text = "+ $cash"
                val randomTranslationX = Random.nextInt(-200, 201).toFloat()
                binding.goldgain.animate().apply {
                    binding.goldgain.animate().alpha(1f).setDuration(750)
                    translationY(-220f).setDuration(750)
                    translationX(randomTranslationX)
                }.withEndAction {
                    binding.goldgain.animate().alpha(0f).setDuration(500)
                    binding.goldgain.animate().translationY(0f)
                    binding.goldgain.animate().translationX(0f)
                }
            } else {

            }
            if (exp == 50 && lvl == 1) {
                exp = 0
                lvl = 2
        }
            else if (exp >= 100 && lvl == 2) {
                exp = 0
                lvl = 3
            }
            else if (exp >= 175 && lvl == 3){
                exp = 0
                lvl = 4
            }
            else if (exp >= 300 && lvl == 4){
                exp = 0
                lvl = 5
            }
            else if (exp >= 500 && lvl == 5){
                exp = 0
                lvl = 6
            }
        }
//        binding.btnSave.setOnClickListener {
//            val gold1 = binding.tvGold.text.toString().toIntOrNull() ?: 0
//            val exp1 = binding.tvExp.text.toString().toIntOrNull() ?: 0
//            val lvl1 = binding.tvLvl.text.toString().toIntOrNull() ?: 0
//            val user = User(gold1, exp1, lvl1)
//            val bundle = bundleOf("user" to user)
//            view.findNavController().navigate(R.id.navigation_home, bundle)
//        }
    }




    override fun onDestroyView() {
        super.onDestroyView()
    }
}