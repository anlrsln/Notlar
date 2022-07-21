package com.example.notlar.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.example.notlar.Classes.ApiUtills
import com.example.notlar.Classes.CRUDCevap
import com.example.notlar.Classes.Notlar
import com.example.notlar.R
import com.example.notlar.databinding.ActivityMainBinding
import com.example.notlar.databinding.ActivityNotDetayBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NotDetayActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNotDetayBinding
    private lateinit var not:Notlar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotDetayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        not = intent.getSerializableExtra("not") as Notlar

        binding.toolbarDetay.title="Not Detay"
        setSupportActionBar(binding.toolbarDetay)


        // Veriler View'lara Aktarıldı
        binding.dersDetayView.setText(not.ders_adi)
        binding.not1DetayView.setText(not.not1.toString())
        binding.not2DetayView.setText(not.not2.toString())


    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.silItem -> {
                notSil(not.not_id)
                startActivity(Intent(this@NotDetayActivity,MainActivity::class.java))
                finish()
                return true
            }
            R.id.duzenleItem ->{
                val yeniDers = binding.dersDetayView.text.toString()
                val yeniNot1 = binding.not1DetayView.text.toString().trim().toInt()
                val yeniNot2 = binding.not2DetayView.text.toString().trim().toInt()
                notGuncelle(not.not_id,yeniDers,yeniNot1,yeniNot2)
                startActivity(Intent(this@NotDetayActivity,MainActivity::class.java))
                finish()
                return true
            }else -> {
            return false
            }
        }

        return super.onOptionsItemSelected(item)
    }

    fun notGuncelle(not_id:Int,ders_adi:String,not1:Int,not2: Int){
        val notDao = ApiUtills.getNotlarDaoInterface()
        notDao.notGuncelle(not_id,ders_adi,not1,not2).enqueue(object : Callback<CRUDCevap> {
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



    fun notSil(not_id:Int){
        val notDao = ApiUtills.getNotlarDaoInterface()

        notDao.notSil(not_id).enqueue(object : Callback<CRUDCevap>{
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