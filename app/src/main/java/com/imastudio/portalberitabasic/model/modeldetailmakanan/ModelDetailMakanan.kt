package com.imastudio.portalberitabasic.model.modeldetailmakanan


import com.google.gson.annotations.SerializedName


data class ModelDetailMakanan(

	@field:SerializedName("meals")
	val meals: List<MealsDetailItem?>? = null
)