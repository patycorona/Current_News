package com.example.currentnews.views.news

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.currentnews.R
import com.example.currentnews.databinding.FragmentItemNewsBinding
import com.example.currentnews.databinding.FragmentLoginBinding
import com.example.currentnews.models.Screen
import com.example.currentnews.views.main.MainActivity


class Item_News_Fragment() : Fragment() {

    var binding: FragmentItemNewsBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentItemNewsBinding.inflate(
            LayoutInflater.from(context), null, false)

       // como hacer para validar si viene de boton entar o del link de invitado para habilitar la camara

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
            Item_News_Fragment().apply {
                arguments = Bundle().apply { }
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}