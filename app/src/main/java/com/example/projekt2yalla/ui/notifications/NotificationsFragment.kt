package com.example.projekt2yalla.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.projekt2yalla.databinding.FragmentNotificationsBinding
import com.example.projekt2yalla.ui.model.GameEnigne

class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textNotifications

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvGold.text = GameEnigne.gold.toString()
        binding.tvExp.text = "Exp: "+ GameEnigne.exp.toString()
        binding.tvLvl.text = "Lvl: "+ GameEnigne.lvl.toString()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}