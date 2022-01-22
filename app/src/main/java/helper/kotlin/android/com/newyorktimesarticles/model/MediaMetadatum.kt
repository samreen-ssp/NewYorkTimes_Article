package helper.kotlin.android.com.newyorktimesarticles.model

import android.os.Parcel
import android.os.Parcelable

import com.google.gson.annotations.SerializedName


class MediaMetadatum() :Parcelable{
    @SerializedName("format")
    private var mFormat: String? = null

    @SerializedName("height")
    private var mHeight: Long? = null

    @SerializedName("url")
    private var mUrl: String? = null

    @SerializedName("width")
    private var mWidth: Long? = null

    constructor(parcel: Parcel) : this() {
        mFormat = parcel.readString()
        mHeight = parcel.readValue(Long::class.java.classLoader) as? Long
        mUrl = parcel.readString()
        mWidth = parcel.readValue(Long::class.java.classLoader) as? Long
    }

    protected fun MediaMetadatum(`in`: Parcel) {
        mFormat = `in`.readString()
        mHeight = if (`in`.readByte().toInt() == 0) {
            null
        } else {
            `in`.readLong()
        }
        mUrl = `in`.readString()
        mWidth = if (`in`.readByte().toInt() == 0) {
            null
        } else {
            `in`.readLong()
        }
    }

    fun getFormat(): String? {
        return mFormat
    }

    fun setFormat(format: String?) {
        mFormat = format
    }

    fun getHeight(): Long? {
        return mHeight
    }

    fun setHeight(height: Long?) {
        mHeight = height
    }

    fun getUrl(): String? {
        return mUrl
    }

    fun setUrl(url: String?) {
        mUrl = url
    }

    fun getWidth(): Long? {
        return mWidth
    }

    fun setWidth(width: Long?) {
        mWidth = width
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, i: Int) {
        parcel.writeString(mFormat)
        if (mHeight == null) {
            parcel.writeByte(0.toByte())
        } else {
            parcel.writeByte(1.toByte())
            parcel.writeLong(mHeight!!)
        }
        parcel.writeString(mUrl)
        if (mWidth == null) {
            parcel.writeByte(0.toByte())
        } else {
            parcel.writeByte(1.toByte())
            parcel.writeLong(mWidth!!)
        }
    }

    companion object CREATOR : Parcelable.Creator<MediaMetadatum> {
        override fun createFromParcel(parcel: Parcel): MediaMetadatum {
            return MediaMetadatum(parcel)
        }

        override fun newArray(size: Int): Array<MediaMetadatum?> {
            return arrayOfNulls(size)
        }
    }
}
