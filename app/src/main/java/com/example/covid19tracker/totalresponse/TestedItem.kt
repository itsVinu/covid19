package com.example.covid19tracker.totalresponse

import com.google.gson.annotations.SerializedName

data class TestedItem(

	@field:SerializedName("testsconductedbyprivatelabs")
	val testsconductedbyprivatelabs: String? = null,

	@field:SerializedName("totalsamplestested")
	val totalsamplestested: String? = null,

	@field:SerializedName("positivecasesfromsamplesreported")
	val positivecasesfromsamplesreported: String? = null,

	@field:SerializedName("samplereportedtoday")
	val samplereportedtoday: String? = null,

	@field:SerializedName("source")
	val source: String? = null,

	@field:SerializedName("updatetimestamp")
	val updatetimestamp: String? = null,

	@field:SerializedName("totalindividualstested")
	val totalindividualstested: String? = null,

	@field:SerializedName("totalpositivecases")
	val totalpositivecases: String? = null
)