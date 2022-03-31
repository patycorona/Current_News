package com.example.currentnews.views.user

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.currentnews.databinding.FragmentUserRegisterBinding
import com.example.currentnews.models.Screen
import com.example.currentnews.views.main.MainActivity

class User_Register_Fragment : Fragment() {

    var binding: FragmentUserRegisterBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentUserRegisterBinding.inflate(
            LayoutInflater.from(context), null, false)

        initListener()

        return binding?.root
    }

    private fun initListener() {
        binding?.tvRegresar?.setOnClickListener {
            (activity as MainActivity)
                .changeScreenProccess(Screen.LoginFragment)
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            User_Register_Fragment().apply {
                arguments = Bundle().apply { }
            }
    }
}