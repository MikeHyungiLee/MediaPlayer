/**
 * @file UserAccount.kt
 * @brief ログインする時にログインしたアカウントの情報を遷移された画面に渡すために使うParcelableクラス
 *
 * @author 李 鉉基(LEE HYUNGI)
 * @date 2020.02.05
 */
package com.hyungilee.mediaplayer.model

import android.os.Parcel
import android.os.Parcelable

class UserAccount constructor(var id:String?, var password:String?):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(password)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UserAccount> {
        override fun createFromParcel(parcel: Parcel): UserAccount {
            return UserAccount(parcel)
        }

        override fun newArray(size: Int): Array<UserAccount?> {
            return arrayOfNulls(size)
        }
    }
}