package com.example.currentnews.views.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.currentnews.R
import com.example.currentnews.databinding.ActivityMainBinding
import com.example.currentnews.models.Screen
import com.example.currentnews.views.login.LoginFragment
import com.example.currentnews.views.news.Item_News_Fragment
import com.example.currentnews.views.user.User_Register_Fragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        changeScreenProccess(Screen.LoginFragment)
    }

    fun changeFragment(fragment: Fragment)
    {
        val ft : FragmentTransaction = supportFragmentManager.beginTransaction()
        ft.replace(R.id.Fragment_principal, fragment)
        ft.commit()
    }

    fun changeScreenProccess(typeScreen: Screen ){
        when (typeScreen){
            Screen.MainA -> {finish()}
            Screen.LoginFragment -> {openLoginFragment()}
            Screen.FragmentRegister -> {openRegisterFragment()}
            Screen.FragmentItemNews -> {openItemNewsFragment()}
        }
    }

    fun openLoginFragment()
    {
        changeFragment(LoginFragment.newInstance())
    }
    fun openRegisterFragment()
    {
        changeFragment(User_Register_Fragment.newInstance())
    }
    fun openItemNewsFragment()
    {
        changeFragment(Item_News_Fragment.newInstance())
    }
}