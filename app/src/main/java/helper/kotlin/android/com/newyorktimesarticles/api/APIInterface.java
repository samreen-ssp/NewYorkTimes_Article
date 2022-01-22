package helper.kotlin.android.com.newyorktimesarticles.api;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIInterface {

    @GET("v2/mostviewed/all-sections/7.json")
    Call<DataResponse> getArticlesList(@Query("api-key") String apiKey);


}
