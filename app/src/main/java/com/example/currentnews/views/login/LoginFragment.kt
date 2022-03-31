package com.example.currentnews.views.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.currentnews.R
import com.example.currentnews.databinding.ActivityMainBinding
import com.example.currentnews.databinding.FragmentLoginBinding
import com.example.currentnews.models.Screen
import com.example.currentnews.views.main.MainActivity

class LoginFragment : Fragment() {

     var binding: FragmentLoginBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(
            LayoutInflater.from(context), null, false)

        initListener()

        return binding?.root
    }

    private fun initListener() {

        binding?.tvSalir?.setOnClickListener {
            onDestroyView()
            (activity as MainActivity)
                .changeScreenProccess(Screen.MainA)
        }
        binding?.tvRegistro?.setOnClickListener {
            (activity as MainActivity)
                .changeScreenProccess(Screen.FragmentRegister)
        }
        binding?.tvEmailVisitante?.setOnClickListener {
            (activity as MainActivity)
                .changeScreenProccess(Screen.FragmentItemNews)
        }
        binding?.btnEnter?.setOnClickListener {
            (activity as MainActivity)
                .changeScreenProccess(Screen.FragmentItemNews)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            LoginFragment().apply {
                arguments = Bundle().apply { }
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}