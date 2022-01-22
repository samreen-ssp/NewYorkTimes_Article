package helper.kotlin.android.com.newyorktimesarticles.viewModel

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.View
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import helper.kotlin.android.com.newyorktimesarticles.DetailActivity
import helper.kotlin.android.com.newyorktimesarticles.model.Article


class ArticleListViewModel (var data: Article,var activity: Activity) : BaseObservable() {

    val title: String
        @Bindable
        get() =  data.getTitle().toString()

    val source: String
        @Bindable
        get() =  "Published By: "+data.getSource().toString()

    val date: String
        @Bindable
        get() =  data.getPublishedDate().toString()

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
