package helper.kotlin.android.com.newyorktimesarticles

import InvokeService
import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import helper.kotlin.android.com.newyorktimesarticles.Utils.Constants.Companion.API_KEY
import helper.kotlin.android.com.newyorktimesarticles.adapter.ArticlesAdapter
import helper.kotlin.android.com.newyorktimesarticles.api.APIInterface
import helper.kotlin.android.com.newyorktimesarticles.api.IApiCallBack
import helper.kotlin.android.com.newyorktimesarticles.api.NetworkClient
import helper.kotlin.android.com.newyorktimesarticles.databinding.ActivityMainBinding
import helper.kotlin.android.com.newyorktimesarticles.model.Article
import helper.kotlin.android.com.newyorktimesarticles.widgets.CustomDialogs
import helper.kotlin.android.com.newyorktimesarticles.widgets.CustomProgressDialog
import kotlinx.android.synthetic.main.view_top_bar.view.*

class MainActivity : Activity(), IApiCallBack {

    val apiInterface = NetworkClient.retrofitClient!!.create(APIInterface::class.java)

    lateinit var binding:ActivityMainBinding
    lateinit var adapter:ArticlesAdapter
    var list:ArrayList<Article> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        LinkUI()

    }



    private fun LinkUI() {
        binding.topBar.tv_title.setText("Most Popular Articles")
        SetRecyclerView()
        CallArticlesService()

    }


    fun CallArticlesService() {
        CustomProgressDialog.showProgressDialog(this)
        InvokeService(
            this,
            "getArticles",
           apiInterface.getArticlesList(API_KEY),
            this
        )
    }
    private fun SetRecyclerView (){
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ArticlesAdapter(this,this,list)
        binding.recyclerView.adapter = adapter
    }

    override fun onSuccess(response: Any?, mode: String?) {
        CustomProgressDialog.dismissProgressDialog()
        val articles = response as JsonArray
        Log.e("result",response.toString())
        populateArticles(articles)
    }

    private fun populateArticles(jsonArry:JsonArray) {
        for (n in 0 until jsonArry.size()) {
            val `object` = jsonArry.get(n) as JsonObject
            val gson = GsonBuilder().serializeNulls().create()
            val data = gson.fromJson(`object`.toString(), Article::class.java)
            list.add(data)
        }
        adapter.notifyDataSetChanged()
    }

    override fun onError(response: String?, mode: String?) {
        CustomProgressDialog.dismissProgressDialog()
        CustomDialogs().showTopNavError(this, "No data found")
    }

}