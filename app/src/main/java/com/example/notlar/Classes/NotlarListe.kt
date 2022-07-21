package com.example.notlar.Classes

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class NotlarListe(@SerializedName("notlar") @Expose val notlar:List<Notlar>,
                  @SerializedName("success") @Expose val success:Int
                  ) {
}