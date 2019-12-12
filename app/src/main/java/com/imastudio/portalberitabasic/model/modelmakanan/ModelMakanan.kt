package com.imastudio.portalberitabasic.model.modelmakanan


import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


data class ModelMakanan(

	@field:SerializedName("meals")
	val meals: List<MealsItem?>? = null
) : Parcelable {
	constructor(parcel: Parcel) : this(parcel.createTypedArrayList(MealsItem)) {
	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeTypedList(meals)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<ModelMakanan> {
		override fun createFromParcel(parcel: Parcel): ModelMakanan {
			return ModelMakanan(parcel)
		}

		override fun newArray(size: Int): Array<ModelMakanan?> {
			return arrayOfNulls(size)
		}
	}
}