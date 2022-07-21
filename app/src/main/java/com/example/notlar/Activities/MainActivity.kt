package com.example.notlar.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notlar.Classes.*
import com.example.notlar.R
import com.example.notlar.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var adapter:NotlarAdapter
    private lateinit var notListe: List<Notlar>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        //Toolbar Ayarlaması
        binding.toolbar.title = "Notlar"
        setSupportActionBar(binding.toolbar)


        // Cardlar Listede alt alta görünmesi için LinearLayoutManager kullanıldı
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        // Notlar alındı
        tumNotlar()

        // Fab Buton
        binding.floatingActionButton.setOnClickListener {
            startActivity(Intent(this@MainActivity,NotKayitActivity::class.java))
        }


        // Not Ortalama




    }
    fun tumNotlar(){
        val notDao = ApiUtills.getNotlarDaoInterface()

        notDao.tumNotlar().enqueue(object : Callback<NotlarListe>{
            override fun onResponse(call: Call<NotlarListe>?, response: Response<NotlarListe>?) {
                if (response!=null){
                    notListe = response.body().notlar
                    adapter = NotlarAdapter(this@MainActivity,notListe)
                    binding.recyclerView.adapter=adapter

                    var notToplam = 0
                    for(n in notListe){
                        notToplam = notToplam + (n.not1+n.not2)/2
                    }
                    binding.toolbar.subtitle="Ortalama : ${notToplam/notListe.size}"
                }
            }
            override fun onFailure(call: Call<NotlarListe>?, t: Throwable?) {
                TODO("Not yet implemented")
            }
        })
    }


}