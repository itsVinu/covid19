package com.example.covid19tracker.totalresponse

import com.google.gson.annotations.SerializedName

data class IndiaCovidResponse(

	@field:SerializedName("cases_time_series")
	val casesTimeSeries: List<CasesTimeSeriesItem>? = null,

	@field:SerializedName("tested")
	val tested: List<TestedItem>? = null,

	@field:SerializedName("statewise")
	val statewise: List<StatewiseItem>? = null
)