package com.example.notlar.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.notlar.Classes.ApiUtills
import com.example.notlar.Classes.CRUDCevap
import com.example.notlar.databinding.ActivityMainBinding
import com.example.notlar.databinding.ActivityNotKayitBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NotKayitActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNotKayitBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotKayitBinding.inflate(layoutInflater)
        setContentView(binding.root)



        //Toolbar Ayar
        binding.kayitToolbar.title="Not Kayıt"
        setSupportActionBar(binding.kayitToolbar)


        binding.kaydetButton.setOnClickListener {

            val ders_adi = binding.dersView.text.toString().trim()
            val not1 = binding.not1View.text.toString().trim().toInt()
            val not2 = binding.not2View.text.toString().trim().toInt()


            notEkle(ders_adi,not1,not2)
            startActivity(Intent(this@NotKayitActivity,MainActivity::class.java))
            finish()

        }



    }


    fun notEkle(ders_adi:String,not1:Int,not2:Int){
        val notDao = ApiUtills.getNotlarDaoInterface()

        notDao.notEkle(ders_adi,not1,not2).enqueue(object : Callback<CRUDCevap> {
            override fun onResponse(call: Call<CRUDCevap>?, response: Response<CRUDCevap>?) {
                if (response!=null){
                    Log.e("Cevap : ",response.body().success.toString())
                }
            }

            override fun onFailure(call: Call<CRUDCevap>?, t: Throwable?) {
                TODO("Not yet implemented")
            }
        })
    }


}