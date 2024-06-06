package com.example.onthetableapp.data.remote.entity

import com.google.gson.annotations.SerializedName


data class SearchIngredient (

  @SerializedName("idIngredient"   ) var idIngredient   : String? = null,
  @SerializedName("strIngredient"  ) var strIngredient  : String? = null,
  @SerializedName("strDescription" ) var strDescription : String? = null,
  @SerializedName("strType"        ) var strType        : String? = null

)