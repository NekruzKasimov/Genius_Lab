package com.niko.genius_app.model

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by Ismet on 3/24/2018.
 */
class Model() : Parcelable {
    var question: String? = null
    var url: String? = null

    constructor(parcel: Parcel) : this() {
        question = parcel.readString()
        url = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(question)
        parcel.writeString(url)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Model> {
        override fun createFromParcel(parcel: Parcel): Model {
            return Model(parcel)
        }

        override fun newArray(size: Int): Array<Model?> {
            return arrayOfNulls(size)
        }
    }
}