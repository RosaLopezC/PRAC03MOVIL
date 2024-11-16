package com.lopez.rosa.laboratoriocalificado03

import com.google.gson.annotations.SerializedName

data class Teacher(
    @SerializedName("name") val name: String,
    @SerializedName("last_name") val lastName: String,
    @SerializedName("phone_number") val phoneNumber: String,
    @SerializedName("email") val email: String,
    @SerializedName("image_url") val imageUrl: String
)
