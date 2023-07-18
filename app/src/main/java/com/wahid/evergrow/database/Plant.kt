package com.wahid.evergrow.database

import android.os.Parcel
import android.os.Parcelable
import androidx.room.PrimaryKey


@androidx.room.Entity
data class Plant(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    var plantName: String?,
    var watering: String?,
    var light: String?,
    val temperature: String?,
    var humidity: String?,
    var soil: String?,
    var fertilizer: String?,
    var dissease: String?,
    var propagation: String?,
    var seasonalCare: String?,
    var growth: String?,
    var date: String?


) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(plantName)
        parcel.writeString(watering)
        parcel.writeString(light)
        parcel.writeString(temperature)
        parcel.writeString(humidity)
        parcel.writeString(soil)
        parcel.writeString(fertilizer)
        parcel.writeString(dissease)
        parcel.writeString(propagation)
        parcel.writeString(seasonalCare)
        parcel.writeString(growth)
        parcel.writeString(date)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Plant> {
        override fun createFromParcel(parcel: Parcel): Plant {
            return Plant(parcel)
        }

        override fun newArray(size: Int): Array<Plant?> {
            return arrayOfNulls(size)
        }
    }
}


