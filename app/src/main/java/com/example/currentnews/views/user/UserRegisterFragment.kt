package com.example.currentnews.views.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.currentnews.databinding.FragmentUserRegisterBinding
import com.example.currentnews.models.Screen
import com.example.currentnews.models.user.AccessResultModel
import com.example.currentnews.viewmodel.UserRegisterViewModel
import com.example.currentnews.views.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserRegisterFragment : Fragment() {

    var binding: FragmentUserRegisterBinding? = null
    private val viewModelUserRegister: UserRegisterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // initListener()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentUserRegisterBinding.inflate(
            LayoutInflater.from(context), null, false
        )

        initUserRegisterObserver()
        initListener()
        return binding?.root
    }

    private fun initUserRegisterObserver() {
        viewModelUserRegister.userRegisterLD.observe(viewLifecycleOwner, userRegisterResult)
    }

    // Callback
    private val userRegisterResult = Observer<AccessResultModel> { accessResultModel ->
        if (accessResultModel.code == "0") {
            Toast.makeText(requireContext(), "Successful registration", Toast.LENGTH_SHORT).show()
            (activity as MainActivity)
                .changeScreenProccess(Screen.LoginFragment)
        } else {
            Toast.makeText(requireContext(), "an error has ocurred", Toast.LENGTH_SHORT).show()
        }
    }

    private fun initListener() {
        binding?.regresar?.setOnClickListener {
            (activity as MainActivity)
                .changeScreenProccess(Screen.LoginFragment)
        }

        binding?.btnuserRegister?.setOnClickListener {
            userRegister(
                binding?.edFirstName?.text.toString(),
                binding?.edLastName?.text.toString(),
                binding?.edEmail?.text.toString(),
                binding?.edPwd?.text.toString()
            )
        }
    }

    fun userRegister(name: String, lastName: String, email: String, password: String) {
        viewModelUserRegister.userRegister(name, lastName, email, password)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            UserRegisterFragment().apply {
                arguments = Bundle().apply { }
            }
    }
}
