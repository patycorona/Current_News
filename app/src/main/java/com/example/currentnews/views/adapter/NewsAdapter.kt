package com.example.currentnews.views.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.currentnews.R
import com.example.currentnews.models.news.NewsModel

class NewsAdapter(
    private val dataSource: MutableList<NewsModel>,
    var onListHitItemClickListener: ((newsModel: NewsModel) -> Unit),
    val context: Context,
    val onItemClickToShare: (() -> Unit)
) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // var id: TextView = view.findViewById(R.id.tv_nombrePlatillo) as TextView
        var title: TextView = view.findViewById(R.id.tv_title_News) as TextView
        var news: TextView = view.findViewById(R.id.tv_description_news) as TextView
        var image: ImageView = view.findViewById(R.id.img_news) as ImageView
        var root: ConstraintLayout =
            view.findViewById(R.id.layout_item_news) as ConstraintLayout
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.fragment_item_news, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.title.text = dataSource[position].title
        viewHolder.news.text = dataSource[position].news
        // viewHolder.imgProduct.setImageDrawable(context.getDrawable(dataSource[position].productPhoto))

        Glide.with(context)
            // .load(context.getDrawable(dataSource[position].productPhoto))
            .load(dataSource[position].image)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .centerCrop()
            .circleCrop()
            .into(viewHolder.image)

        viewHolder.root.setOnClickListener {
            onListHitItemClickListener.invoke(dataSource[position])
        }
    }

    override fun getItemCount() = dataSource.size
}
