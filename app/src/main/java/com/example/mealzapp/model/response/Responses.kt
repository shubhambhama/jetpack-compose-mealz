package com.example.mealzapp.model.response

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class MealsCategoriesResponse(val categories: List<MealResponse>)

@Keep
data class MealResponse(
    @SerializedName("idCategory") val id: String,
    @SerializedName("strCategory") val name: String,
    @SerializedName("strCategoryThumb") val imageUrl: String,
    @SerializedName("strCategoryDescription") val description: String
)