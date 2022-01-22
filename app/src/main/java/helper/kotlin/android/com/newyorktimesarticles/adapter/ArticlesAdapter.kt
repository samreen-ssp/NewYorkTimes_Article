package helper.kotlin.android.com.newyorktimesarticles.adapter

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import helper.kotlin.android.com.newyorktimesarticles.DetailActivity
import helper.kotlin.android.com.newyorktimesarticles.databinding.ItemArticleListBinding
import helper.kotlin.android.com.newyorktimesarticles.model.Article
import helper.kotlin.android.com.newyorktimesarticles.viewModel.ArticleListViewModel

class ArticlesAdapter(private val mContext: Context,val baseActivity: Activity,
                      val list: ArrayList<Article>) : RecyclerView.Adapter<ArticlesAdapter.ViewHolder>(),
    View.OnClickListener {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding = ItemArticleListBinding.inflate(LayoutInflater.from(parent.context), parent,
            false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {

        holder.bindData(list,position,baseActivity)


    }




    override fun getItemCount(): Int {
        return list.size
    }


    inner class ViewHolder internal constructor(internal var mBinding: ItemArticleListBinding) : RecyclerView.ViewHolder(mBinding.root){

        fun bindData(data: ArrayList<Article>, position: Int,baseActivity: Activity) {
            mBinding.vm = data.get(position).let { ArticleListViewModel(it,baseActivity ) }


        }


    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }


}