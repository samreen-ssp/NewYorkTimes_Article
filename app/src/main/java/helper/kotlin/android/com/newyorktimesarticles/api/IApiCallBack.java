package helper.kotlin.android.com.newyorktimesarticles.api;

public interface IApiCallBack {

    void onSuccess(Object response, String mode);
    void onError(String response, String mode);

}
