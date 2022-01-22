
package helper.kotlin.android.com.newyorktimesarticles.widgets

import android.app.Activity
import android.app.ProgressDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable

import java.util.Objects

import android.view.Window
import helper.kotlin.android.com.newyorktimesarticles.R

class CustomProgressDialog {

companion object{
    private var progressDialog: ProgressDialog? = null

    @JvmStatic
    fun showProgressDialog(context: Context) {
        progressDialog = ProgressDialog(context)
        val activity = context as Activity
        if (!activity.isFinishing) {
            progressDialog!!.setCanceledOnTouchOutside(false)
            progressDialog!!.setCancelable(false)
            progressDialog!!.setInverseBackgroundForced(true)
            Objects.requireNonNull<Window>(progressDialog!!.window).setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            progressDialog!!.show()
            progressDialog!!.setContentView(R.layout.view_progress_dialog)
        }
    }
    @JvmStatic
    fun dismissProgressDialog() {
            progressDialog?.dismiss()
    }
    @JvmStatic

    fun isShowing(): Boolean {
        return progressDialog == null || !progressDialog?.isShowing!!
    }


}


}

