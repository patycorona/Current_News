package com.example.currentnews.views.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.currentnews.databinding.FragmentItemNewsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ItemNewsFragment() : Fragment() {

    var binding: FragmentItemNewsBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentItemNewsBinding.inflate(
            LayoutInflater.from(context), null, false
        )

        return binding?.root
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            ItemNewsFragment().apply {
                arguments = Bundle().apply { }
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
