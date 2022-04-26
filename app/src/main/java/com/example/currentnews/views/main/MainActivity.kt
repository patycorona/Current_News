package com.example.currentnews.views.main

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.currentnews.R
import com.example.currentnews.databinding.ActivityMainBinding
import com.example.currentnews.models.Screen
import com.example.currentnews.views.login.LoginFragment
import com.example.currentnews.views.news.AddNewsFragment
import com.example.currentnews.views.news.ItemNewsFragment
import com.example.currentnews.views.user.UserRegisterFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        initListener()
        changeScreenProccess(Screen.LoginFragment)
    }

    fun changeFragment(fragment: Fragment) {
        // poner el boton invisible por default

        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
        ft.replace(R.id.Fragment_principal, fragment)
        ft.commit()
    }

    private fun initListener() {
        binding?.tvSalir?.setOnClickListener {
            finish()
        }
        binding?.btnAddNews?.setOnClickListener {
            openAddNewsFragment()
        }
    }

    fun createAddNewsControlVisivility(visivility: Boolean) {
        if (visivility) {
            binding?.btnAddNews?.visibility = View.VISIBLE
            binding?.tvSalir?.visibility = View.VISIBLE
        } else {
            binding?.btnAddNews?.visibility = View.GONE
            binding?.tvSalir?.visibility = View.GONE
        }
    }

    fun changeScreenProccess(typeScreen: Screen) {
        when (typeScreen) {
            Screen.MainA -> {
                openMainFragment()
                createAddNewsControlVisivility(false)
            }
            Screen.LoginFragment -> {
                openLoginFragment()
            }
            Screen.UserRegisterFragment -> {
                openRegisterFragment()
            }
            Screen.MainFragment -> {
                createAddNewsControlVisivility(true)
                openMainFragment()
            }
            Screen.ItemNewsFragment -> {
                openItemNewsFragment()
            }
            Screen.AddNewsFragment -> {
                openAddNewsFragment()
            }
        }
    }

    fun openLoginFragment() {
        changeFragment(LoginFragment.newInstance())
    }

    fun openMainFragment() {
        changeFragment(MainFragment.newInstance())
    }

    fun openRegisterFragment() {
        changeFragment(UserRegisterFragment.newInstance())
    }

    fun openItemNewsFragment() {
        changeFragment(ItemNewsFragment.newInstance())
    }

    fun openAddNewsFragment() {
        changeFragment(AddNewsFragment.newInstance())
    }
}
