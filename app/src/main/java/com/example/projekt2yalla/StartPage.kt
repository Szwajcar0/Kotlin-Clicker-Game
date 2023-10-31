package com.example.projekt2yalla

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet.Constraint
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.projekt2yalla.databinding.ActivityStartPageBinding
import com.google.android.material.snackbar.Snackbar

class StartPage : AppCompatActivity() {

    private lateinit var binding: ActivityStartPageBinding
    private var firstRun = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onResume() {
        super.onResume()


        if(firstRun == true) {
            firstRun = false
            binding.ivPickaxe.animate()
                .apply {
                    duration = 3000
                    rotationXBy(360f)
                    alpha(1f).setDuration(2000)
                    scaleXBy(.5f).setDuration(2000)
                    scaleYBy(.5f).setDuration(2000)
                }.start()
            binding.ivStone.animate()
                .apply {
                    alpha(1f).setDuration(2000)
                }
        }else {
            firstRun = false
        }
    }
}