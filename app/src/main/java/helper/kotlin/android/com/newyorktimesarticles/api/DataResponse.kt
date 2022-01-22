package helper.kotlin.android.com.newyorktimesarticles.api;

import com.google.gson.JsonElement
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class DataResponse {

    @SerializedName("status")
    @Expose
    var status: String?=null

    @SerializedName("num_results")
    @Expose
    var num_results: Int?=null

    @SerializedName("copyright")
    @Expose
    var copyright: String?=null


    @SerializedName("results")
    @Expose
    var data: JsonElement?=null
    /**
     *  @SerializedName("num_results")
    public int numResults;
    @SerializedName("status")
    public String status;
    @SerializedName("copyright")
    public String copyright;

    @SerializedName("results")
    public List<Article> articles;

    public int getNumResults() {
    return numResults;
    }

    public void setNumResults(int numResults) {
    this.numResults = numResults;
    }

    public String getStatus() {
    return status;
    }

    public void setStatus(String status) {
    this.status = status;
    }

    public String getCopyright() {
    return copyright;
    }

    public void setCopyright(String copyright) {
    this.copyright = copyright;
    }

    public List<Article> getArticles() {
    return articles;
    }

    public void setArticles(List<Article> articles) {
    this.articles = articles;
    }
     */
}
