package com.example.notlar.Classes

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Notlar(@SerializedName("not_id") @Expose val not_id:Int,
                  @SerializedName("ders_adi") @Expose val ders_adi:String,
                  @SerializedName("not1") @Expose val not1:Int,
                  @SerializedName("not2") @Expose val not2:Int
                  ):Serializable