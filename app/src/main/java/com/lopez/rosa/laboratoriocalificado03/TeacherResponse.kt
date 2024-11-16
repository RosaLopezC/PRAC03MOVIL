package com.lopez.rosa.laboratoriocalificado03

import com.google.gson.annotations.SerializedName

data class TeacherResponse(
    @SerializedName("teachers") val teachers: List<Teacher>
)
