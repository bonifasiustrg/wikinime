package com.takasima.wikinime

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Character (
    val photo: Int,
    val name: String,
    val detail: String
) : Parcelable