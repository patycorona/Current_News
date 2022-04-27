package com.example.currentnews.views.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.currentnews.databinding.FragmentLoginBinding
import com.example.currentnews.models.Screen
import com.example.currentnews.models.user.AccessResultModel
import com.example.currentnews.viewmodel.NewsViewModel
import com.example.currentnews.views.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    var binding: FragmentLoginBinding? = null
    private val viewModelUserAccess: NewsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(
            LayoutInflater.from(context), null, false
        )

        initListener()
        initLoginObserver()

        return binding?.root
    }

    private fun initListener() {

        binding?.btnEnter?.setOnClickListener {
            validUser(
                binding?.edUserName?.text.toString(),
                binding?.edPassword?.text.toString()
            )
        }
        binding?.tvSalir?.setOnClickListener {
            onDestroyView()
            (activity as MainActivity)
                .changeScreenProccess(Screen.MainA)
        }
        binding?.tvRegistro?.setOnClickListener {
            (activity as MainActivity)
                .changeScreenProccess(Screen.UserRegisterFragment)
        }
        binding?.tvEmailVisitante?.setOnClickListener {
            (activity as MainActivity)
                .changeScreenProccess(Screen.MainA)
        }
    }

    // Callback
    private val useraccessResultObserver = Observer<AccessResultModel> { accessResultModel ->
        if (accessResultModel.code == "0") {

            Toast.makeText(requireContext(), "Bienvenido", Toast.LENGTH_SHORT).show()

            (activity as MainActivity)
                .changeScreenProccess(Screen.MainFragment)
        } else {

            Toast.makeText(
                requireContext(),
                "the username or password is invalid",
                Toast.LENGTH_SHORT
            ).show()
            // Toast.makeText(this,"the username or password is invalid", Toast.LENGTH_SHORT).show()
        }
    }

    private fun initLoginObserver() {
        viewModelUserAccess.userAccessResult.observe(viewLifecycleOwner, useraccessResultObserver)
    }

    fun validUser(user: String, pwd: String) {
        viewModelUserAccess.userValidation(user, pwd)
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
