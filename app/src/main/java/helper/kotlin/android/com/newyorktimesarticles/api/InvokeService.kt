
import android.content.Context
import android.util.Log
import helper.kotlin.android.com.newyorktimesarticles.R
import helper.kotlin.android.com.newyorktimesarticles.api.DataResponse
import helper.kotlin.android.com.newyorktimesarticles.api.IApiCallBack
import helper.kotlin.android.com.newyorktimesarticles.widgets.CustomDialogs
import helper.kotlin.android.com.newyorktimesarticles.widgets.CustomProgressDialog
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InvokeService(
    private val mCtx: Context,
    private val mMode: String,
    private val api_call: Call<DataResponse>?,
    private val mCallback: IApiCallBack?
) {


    init {


        CallApi()

    }


    private fun CallApi() {

        Log.e("URL:", api_call?.request()?.url().toString())

        api_call?.enqueue(object : Callback<DataResponse> {

            override fun onResponse(call: Call<DataResponse>, response: Response<DataResponse>) {
                if (response.isSuccessful) {
                    val result = response.body()
                    if (result?.status .equals("OK")) {
                        mCallback?.onSuccess(result?.data, mMode)
                        Log.e(
                            "SUCCESS::",
                            "<< Response Code:>> " + response.code() + "\n<< Data: >> " + response.body()?.data
                        )

                    } else {
                        mCallback?.onError(result?.status, mMode)
                        Log.e(
                            "API ON RESPONSE::",
                            "<< Response Code:>> " + response.code() + "\n<< Data: >> " + response.message()
                        )
                    }

                } else {
                    mCallback?.onError(response.message(), mMode)
                    Log.e(
                        "API ON ERROR::",
                        "<< Response Code:>> " + response.code() + "\n<< Data: >> " + response.message()
                    )

                }


            }

            override fun onFailure(call: Call<DataResponse>, t: Throwable) {
                CustomProgressDialog.dismissProgressDialog()

                Log.e("API ON FAILURE::", "<< Response Code:>> " + t.message)
                CustomDialogs().showTopNavError(mCtx,
                    mCtx.resources.getString(R.string.txt_session_timeout)

                )

            }
        })


    }


}
