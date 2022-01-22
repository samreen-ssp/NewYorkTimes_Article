package helper.kotlin.android.com.newyorktimesarticles.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable
import android.os.Parcel
import android.os.Parcelable


class Article() : Parcelable
{
    @SerializedName("abstract")
    private var mAbstract: String? = null

    @SerializedName("adx_keywords")
    private var mAdxKeywords: String? = null

    @SerializedName("asset_id")
    private var mAssetId: Long? = null

    @SerializedName("byline")
    private var mByline: String? = null

    @SerializedName("column")
    private var mColumn: Any? = null

    @SerializedName("des_facet")
    private var mDesFacet: Any? = null

    @SerializedName("geo_facet")
    private var mGeoFacet: Any? = null

    @SerializedName("id")
    private var mId: Long? = null

    @SerializedName("media")
    private var mMedia: List<Medium?>? = null

    @SerializedName("org_facet")
    private var mOrgFacet: Any? = null

    @SerializedName("per_facet")
    private var mPerFacet: Any? = null

    @SerializedName("published_date")
    private var mPublishedDate: String? = null

    @SerializedName("section")
    private var mSection: String? = null

    @SerializedName("source")
    private var mSource: String? = null

    @SerializedName("title")
    private var mTitle: String? = null

    @SerializedName("type")
    private var mType: String? = null

    @SerializedName("url")
    private var mUrl: String? = null

    @SerializedName("views")
    private var mViews: Long? = null

    constructor(parcel: Parcel) : this() {
        mAbstract = parcel.readString()
        mAdxKeywords = parcel.readString()
        mAssetId = parcel.readValue(Long::class.java.classLoader) as? Long
        mByline = parcel.readString()
        mId = parcel.readValue(Long::class.java.classLoader) as? Long
        mMedia = parcel.createTypedArrayList(Medium)
        mPublishedDate = parcel.readString()
        mSection = parcel.readString()
        mSource = parcel.readString()
        mTitle = parcel.readString()
        mType = parcel.readString()
        mUrl = parcel.readString()
        mViews = parcel.readValue(Long::class.java.classLoader) as? Long
    }

    protected fun Article(`in`: Parcel) {
        mAbstract = `in`.readString()
        mAdxKeywords = `in`.readString()
        mAssetId = if (`in`.readByte().toInt() == 0) {
            null
        } else {
            `in`.readLong()
        }
        mByline = `in`.readString()
        mId = if (`in`.readByte().toInt() == 0) {
            null
        } else {
            `in`.readLong()
        }
        mMedia = `in`.createTypedArrayList(Medium)
        mPublishedDate = `in`.readString()
        mSection = `in`.readString()
        mSource = `in`.readString()
        mTitle = `in`.readString()
        mType = `in`.readString()
        mUrl = `in`.readString()
        mViews = if (`in`.readByte().toInt() == 0) {
            null
        } else {
            `in`.readLong()
        }
    }

    fun getAbstract(): String? {
        return mAbstract
    }

    fun setAbstract(mAbstract: String?) {
        this.mAbstract = mAbstract
    }

    fun getAdxKeywords(): String? {
        return mAdxKeywords
    }

    fun setAdxKeywords(adxKeywords: String?) {
        mAdxKeywords = adxKeywords
    }

    fun getAssetId(): Long? {
        return mAssetId
    }

    fun setAssetId(assetId: Long?) {
        mAssetId = assetId
    }

    fun getByline(): String? {
        return mByline
    }

    fun setByline(byline: String?) {
        mByline = byline
    }

    fun getColumn(): Any? {
        return mColumn
    }

    fun setColumn(column: Any?) {
        mColumn = column
    }

    fun getDesFacet(): Any? {
        return mDesFacet
    }

    fun setDesFacet(desFacet: List<String?>?) {
        mDesFacet = desFacet
    }

    fun getGeoFacet(): Any? {
        return mGeoFacet
    }

    fun setGeoFacet(geoFacet: String?) {
        mGeoFacet = geoFacet
    }

    fun getId(): Long? {
        return mId
    }

    fun setId(id: Long?) {
        mId = id
    }

    fun getMedia(): List<Medium?>? {
        return mMedia
    }

    fun setMedia(media: List<Medium?>?) {
        mMedia = media
    }

    fun getOrgFacet(): Any? {
        return mOrgFacet
    }

    fun setOrgFacet(orgFacet: String?) {
        mOrgFacet = orgFacet
    }

    fun getPerFacet(): Any? {
        return mPerFacet
    }

    fun setPerFacet(perFacet: List<String?>?) {
        mPerFacet = perFacet
    }

    fun getPublishedDate(): String? {
        return mPublishedDate
    }

    fun setPublishedDate(publishedDate: String?) {
        mPublishedDate = publishedDate
    }

    fun getSection(): String? {
        return mSection
    }

    fun setSection(section: String?) {
        mSection = section
    }

    fun getSource(): String? {
        return mSource
    }

    fun setSource(source: String?) {
        mSource = source
    }

    fun getTitle(): String? {
        return mTitle
    }

    fun setTitle(title: String?) {
        mTitle = title
    }

    fun getType(): String? {
        return mType
    }

    fun setType(type: String?) {
        mType = type
    }

    fun getUrl(): String? {
        return mUrl
    }

    fun setUrl(url: String?) {
        mUrl = url
    }

    fun getViews(): Long? {
        return mViews
    }

    fun setViews(views: Long?) {
        mViews = views
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, i: Int) {
        parcel.writeString(mAbstract)
        parcel.writeString(mAdxKeywords)
        if (mAssetId == null) {
            parcel.writeByte(0.toByte())
        } else {
            parcel.writeByte(1.toByte())
            parcel.writeLong(mAssetId!!)
        }
        parcel.writeString(mByline)
        if (mId == null) {
            parcel.writeByte(0.toByte())
        } else {
            parcel.writeByte(1.toByte())
            parcel.writeLong(mId!!)
        }
        parcel.writeTypedList(mMedia)
        parcel.writeString(mPublishedDate)
        parcel.writeString(mSection)
        parcel.writeString(mSource)
        parcel.writeString(mTitle)
        parcel.writeString(mType)
        parcel.writeString(mUrl)
        if (mViews == null) {
            parcel.writeByte(0.toByte())
        } else {
            parcel.writeByte(1.toByte())
            parcel.writeLong(mViews!!)
        }
    }

    companion object CREATOR : Parcelable.Creator<Article> {
        override fun createFromParcel(parcel: Parcel): Article {
            return Article(parcel)
        }

        override fun newArray(size: Int): Array<Article?> {
            return arrayOfNulls(size)
        }
    }

}