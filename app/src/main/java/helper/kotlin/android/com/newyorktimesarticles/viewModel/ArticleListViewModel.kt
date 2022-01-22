package helper.kotlin.android.com.newyorktimesarticles.viewModel

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.View
import android.widget.ImageView
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import helper.kotlin.android.com.newyorktimesarticles.DetailActivity
import helper.kotlin.android.com.newyorktimesarticles.R
import helper.kotlin.android.com.newyorktimesarticles.model.Article
import helper.kotlin.android.com.newyorktimesarticles.model.Medium


class ArticleListViewModel (var data: Article,var activity: Activity) : BaseObservable() {


    companion object {
        @JvmStatic  @BindingAdapter("app:imageUri")
        fun loadImageWithUri(imageView: ImageView, imageUri: String){
            Glide.with(imageView.context).load(Uri.parse(imageUri)).placeholder(R.drawable.img).into(imageView)
        }
    }
    val title: String
        @Bindable
        get() =  data.getTitle().toString()

    val source: String
        @Bindable
        get() =  data.getSource().toString()

    val date: String
        @Bindable
        get() =  data.getPublishedDate().toString()

    val imageUri: String
        @Bindable
        get() =  if(data.getMedia()?.size!! >0)
        {
            data.getMedia()?.get(0)?.getMediaMetadata()?.get(0)?.getUrl().toString()

        }
    else
        {
             "";
        }

    fun onItemSelection(): View.OnClickListener {
        return View.OnClickListener { view ->

            val i = Intent(activity.baseContext, DetailActivity::class.java)
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            i.putExtra("title", title)
            i.putExtra("url", data.getUrl())
            activity.startActivity(i)
        }
    }
}
