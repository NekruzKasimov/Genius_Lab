package com.niko.genius_app.model

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by Ismet on 3/24/2018.
 */
class Tips() :Parcelable{
    var title: String? = null
    var body: String? = null

    constructor(parcel: Parcel) : this() {
        title = parcel.readString()
        body = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(body)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Tips> {
        override fun createFromParcel(parcel: Parcel): Tips {
            return Tips(parcel)
        }

        override fun newArray(size: Int): Array<Tips?> {
            return arrayOfNulls(size)
        }
    }
}