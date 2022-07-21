package com.example.notlar.Classes

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.notlar.Activities.NotDetayActivity
import com.example.notlar.databinding.CardViewBinding

class NotlarAdapter(private val mContext: Context, private val notlarListe: List<Notlar>) : RecyclerView.Adapter<NotlarAdapter.CardTasarimTutucu>(){


    // CardView Elemanlara erişim
    inner class CardTasarimTutucu(val binding: CardViewBinding):RecyclerView.ViewHolder(binding.root)




    //CardView xml dosyasına erişim
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val binding = CardViewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CardTasarimTutucu(binding)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val not = notlarListe.get(position)
        holder.binding.viewDers.text = not.ders_adi
        holder.binding.viewNot1.text = not.not1.toString()
        holder.binding.viewNot2.text = not.not2.toString()

        holder.binding.cardView.setOnClickListener {
            val intent = Intent(mContext,NotDetayActivity::class.java)
            intent.putExtra("not",not)
            mContext.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
         return notlarListe.size
    }


}