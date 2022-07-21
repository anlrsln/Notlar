package com.example.notlar.Classes

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CRUDCevap(@SerializedName("success") @Expose val success:Int,
                @SerializedName("message") @Expose val message:String
                ) {
}