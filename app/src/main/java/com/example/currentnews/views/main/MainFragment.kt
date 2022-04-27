package com.example.currentnews.views.main

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.currentnews.databinding.FragmentMainBinding
import com.example.currentnews.models.news.NewsModel
import com.example.currentnews.models.news.NewsResult
import com.example.currentnews.viewmodel.NewsViewModel
import com.example.currentnews.views.adapter.NewsAdapter
import com.example.currentnews.views.component.NewsDetBottomSheet
import dagger.hilt.android.AndroidEntryPoint

private const val ARG_PARAM1 = "visit"

@AndroidEntryPoint
class MainFragment : Fragment() {

    var binding: FragmentMainBinding? = null
    private val viewModelNews: NewsViewModel by viewModels()

    private val listNewsObserver = Observer<NewsResult> { newsResult ->
        if (newsResult.sussess) {
            newsResult.list?.let {
                val adapter = NewsAdapter(
                    it,
                    onItemClickListener,
                    requireContext(),
                    onItemClickToShare
                )
                binding?.recyclerview?.adapter = adapter
                adapter.notifyDataSetChanged()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
        initObserver()
        viewModelNews.getNews()
        return binding?.root
    }

    private var onItemClickListener: ((newsmodel: NewsModel) -> Unit) = { news ->
        Toast.makeText(requireContext(), "Noticia: " + news.title, Toast.LENGTH_SHORT).show()

        // meter aqui el  redirect para el BottomSheet
        NewsDetBottomSheet.newInstance(
            news.title,
            news.news,
            news.image
        )
            .show(requireActivity().supportFragmentManager, "")
    }

    private var onItemClickToShare: ((newsmodel: NewsModel) -> Unit) = { news ->
        shareOptions(news.title)
    }

    private fun shareOptions(title: String) {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, "share news, $title")
            type = "text/plain"
        }
        // preguntar a marco si es correcto originalmente solo lleva el this
        val shareIntent = Intent.createChooser(sendIntent, this.toString())
        startActivity(shareIntent)
    }

    private fun initObserver() {
        viewModelNews.listNewsRs.observe(viewLifecycleOwner, listNewsObserver)
    }

    // preguntar a  marco
    private fun initRecycler() {
        val linearLayoutManager = LinearLayoutManager(requireContext())
        binding?.recyclerview?.apply {
            layoutManager = linearLayoutManager
            isNestedScrollingEnabled = false
            setHasFixedSize(true)
            // itemAnimator = DefaultItemAnimator()
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = MainFragment().apply {
            arguments = Bundle().apply {
            }
        }
    }
}
