package helper.kotlin.android.com.newyorktimesarticles.model

import android.os.Parcel
import android.os.Parcelable

import com.google.gson.annotations.SerializedName

import android.os.Parcelable.Creator


class Medium() :Parcelable {



    @SerializedName("approved_for_syndication")
    private var mApprovedForSyndication: Long? = null

    @SerializedName("caption")
    private var mCaption: String? = null

    @SerializedName("copyright")
    private var mCopyright: String? = null

    @SerializedName("media-metadata")
    private var mMediaMetadata: List<MediaMetadatum?>? = null

    @SerializedName("subtype")
    private var mSubtype: String? = null

    @SerializedName("type")
    private var mType: String? = null

    constructor(parcel: Parcel) : this() {
        mApprovedForSyndication = parcel.readValue(Long::class.java.classLoader) as? Long
        mCaption = parcel.readString()
        mCopyright = parcel.readString()
        mSubtype = parcel.readString()
        mType = parcel.readString()
    }

    protected fun Medium(`in`: Parcel) {
        mApprovedForSyndication = if (`in`.readByte().toInt() == 0) {
            null
        } else {
            `in`.readLong()
        }
        mCaption = `in`.readString()
        mCopyright = `in`.readString()
        mMediaMetadata = `in`.createTypedArrayList<MediaMetadatum>(MediaMetadatum.CREATOR)
        mSubtype = `in`.readString()
        mType = `in`.readString()
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        if (mApprovedForSyndication == null) {
            dest.writeByte(0.toByte())
        } else {
            dest.writeByte(1.toByte())
            dest.writeLong(mApprovedForSyndication!!)
        }
        dest.writeString(mCaption)
        dest.writeString(mCopyright)
        dest.writeTypedList(mMediaMetadata)
        dest.writeString(mSubtype)
        dest.writeString(mType)
    }

    override fun describeContents(): Int {
        return 0
    }

    fun getApprovedForSyndication(): Long? {
        return mApprovedForSyndication
    }

    fun setApprovedForSyndication(approvedForSyndication: Long?) {
        mApprovedForSyndication = approvedForSyndication
    }

    fun getCaption(): String? {
        return mCaption
    }

    fun setCaption(caption: String?) {
        mCaption = caption
    }

    fun getCopyright(): String? {
        return mCopyright
    }

    fun setCopyright(copyright: String?) {
        mCopyright = copyright
    }

    fun getMediaMetadata(): List<MediaMetadatum?>? {
        return mMediaMetadata
    }

    fun setMediaMetadata(mediaMetadata: List<MediaMetadatum?>?) {
        mMediaMetadata = mediaMetadata
    }

    fun getSubtype(): String? {
        return mSubtype
    }

    fun setSubtype(subtype: String?) {
        mSubtype = subtype
    }

    fun getType(): String? {
        return mType
    }

    fun setType(type: String?) {
        mType = type
    }

    companion object CREATOR : Creator<Medium> {
        override fun createFromParcel(parcel: Parcel): Medium {
            return Medium(parcel)
        }

        override fun newArray(size: Int): Array<Medium?> {
            return arrayOfNulls(size)
        }
    }
}
