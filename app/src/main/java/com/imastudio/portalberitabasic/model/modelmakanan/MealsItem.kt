package com.imastudio.portalberitabasic.model.modelmakanan


import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


data class MealsItem(

	@field:SerializedName("strMealThumb")
	val strMealThumb: String? = null,

	@field:SerializedName("idMeal")
	val idMeal: String? = null,

	@field:SerializedName("strMeal")
	val strMeal: String? = null
) : Parcelable {
	constructor(parcel: Parcel) : this(
		parcel.readString(),
		parcel.readString(),
		parcel.readString()
	) {
	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeString(strMealThumb)
		parcel.writeString(idMeal)
		parcel.writeString(strMeal)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<MealsItem> {
		override fun createFromParcel(parcel: Parcel): MealsItem {
			return MealsItem(parcel)
		}

		override fun newArray(size: Int): Array<MealsItem?> {
			return arrayOfNulls(size)
		}
	}
}