package helper.kotlin.android.com.newyorktimesarticles

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.djetops.flightsupportclient.common.widgets.CustomTopBar
import helper.kotlin.android.com.newyorktimesarticles.databinding.ActivityDetailBinding
import kotlinx.android.synthetic.main.view_top_bar.view.*


class DetailActivity : Activity(), View.OnClickListener {
    lateinit var mContext: Context
    lateinit var binding: ActivityDetailBinding
    lateinit var url:String
    lateinit var title:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContext = this
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        ReadArg()
    }

    private fun ReadArg() {
        title= intent.getStringExtra("title").toString()
        url=intent.getStringExtra("url").toString()
        LinkUI()
    }


    private fun LinkUI() {
        binding.topBar.tv_title.setText(title)
        binding.topBar.btn_back.visibility=View.VISIBLE
        binding.topBar.btn_back.setOnClickListener(this)
        showData()
    }

    private fun showData() {
        binding.webview.settings.setJavaScriptEnabled(true)
        binding.webview.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                url?.let { view?.loadUrl(it) }
                return true
            }
        }
        binding.webview.loadUrl(url)
    }



    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_back -> finish()
        }
    }
}
