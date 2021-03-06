package com.muhammadfurqan.bangkit_e_class.list.presentation.model

import android.os.Parcel
import android.os.Parcelable
import com.muhammadfurqan.bangkit_e_class.answer.Visitable
import com.muhammadfurqan.bangkit_e_class.answer.adapter.AnswerAdapter

/**
 * @author by furqan on 18/03/2021
 */
class NationalHero(
    val name: String = "",
    val imageUrl: String = "",
    val description: String = ""
) : Visitable(), Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(imageUrl)
        parcel.writeString(description)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<NationalHero> {
        override fun createFromParcel(parcel: Parcel): NationalHero {
            return NationalHero(parcel)
        }

        override fun newArray(size: Int): Array<NationalHero?> {
            return arrayOfNulls(size)
        }
    }

    override fun getViewType(): Int =
        AnswerAdapter.HERO_TYPE

}