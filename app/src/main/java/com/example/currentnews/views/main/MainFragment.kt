package com.example.currentnews.views.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.currentnews.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    var binding: FragmentMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(
            LayoutInflater.from(context), null, false
        )

        initRecycler()

        return binding?.root
    }

    // preguntar a  marco
    private fun initRecycler() {
        val linearLayoutManager = LinearLayoutManager(context)
        binding?.recyclerview?.apply {
            layoutManager = linearLayoutManager
            isNestedScrollingEnabled = false
            setHasFixedSize(true)
            // itemAnimator = DefaultItemAnimator()
        }
    }

    /*  private fun initListener() {
          binding?.tvSalir?.setOnClickListener {
              (activity as MainActivity)
                  .finish()
          }
          binding?.btnAddNews?.setOnClickListener {
              (activity as MainActivity)
                  .changeScreenProccess(Screen.AddNewsFragment)
          }
      }*/

    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() = MainFragment().apply {
            arguments = Bundle().apply {
            }
        }
    }
}
