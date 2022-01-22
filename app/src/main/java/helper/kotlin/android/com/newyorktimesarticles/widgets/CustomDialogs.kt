
package helper.kotlin.android.com.newyorktimesarticles.widgets

import android.app.Activity
import android.content.Context
import android.view.View
import com.tapadoo.alerter.Alerter
import helper.kotlin.android.com.newyorktimesarticles.R


class CustomDialogs {


    fun showTopNavError(context: Context, msg: String) {
        CustomProgressDialog.dismissProgressDialog()
        val activity = context as Activity
            Alerter.create(activity)
                .setTitle("Error")
                .setText(msg)
                .setBackgroundColorRes(R.color.teal_700)
                .setIcon(R.drawable.cancelled)
                .enableSwipeToDismiss()
                .setIconColorFilter(0) // Optional - Removes white tint
                .setDuration(10000)
                .setOnClickListener {
                    if (Alerter.isShowing()) {
                        Alerter.hide()
                    }
                }
                .show()
    }








   /* fun showInternetDialog(mCtx: Context) {
        if (!HelperMethods().isOnline(mCtx)) {
            if (!CustomInternetDialog.isInFront) {
                CustomProgressDialog.dismissProgressDialog()
                val i = Intent(mCtx, CustomInternetDialog::class.java)
                i.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                mCtx.startActivity(i)
            }
        }
    }*/


}



