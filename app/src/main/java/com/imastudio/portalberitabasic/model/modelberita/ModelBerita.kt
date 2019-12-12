package com.imastudio.portalberitabasic.model.modelberita


import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


data class ModelBerita(

    @field:SerializedName("totalResults")
	val totalResults: Int? = null,

    @field:SerializedName("articles")
	val articles: List<ArticlesItem?>? = null,

    @field:SerializedName("status")
	val status: String? = null
) : Parcelable {
	constructor(parcel: Parcel) : this(
		parcel.readValue(Int::class.java.classLoader) as? Int,
		parcel.createTypedArrayList(ArticlesItem),
		parcel.readString()
	) {
	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeValue(totalResults)
		parcel.writeTypedList(articles)
		parcel.writeString(status)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<ModelBerita> {
		override fun createFromParcel(parcel: Parcel): ModelBerita {
			return ModelBerita(parcel)
		}

		override fun newArray(size: Int): Array<ModelBerita?> {
			return arrayOfNulls(size)
		}
	}
}