package com.example.currentnews.views.news

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.currentnews.R


class Det_News_Fragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_det_news, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            Det_News_Fragment().apply {
                arguments = Bundle().apply { }
            }
    }
}