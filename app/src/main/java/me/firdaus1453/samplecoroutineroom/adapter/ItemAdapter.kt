package me.firdaus1453.samplecoroutineroom.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.list_item.view.*
import me.firdaus1453.samplecoroutineroom.R
import me.firdaus1453.samplecoroutineroom.database.Barang

class ItemAdapter(var data: List<Barang>) : RecyclerView.Adapter<ItemAdapter.MyViewHolder>() {
    //
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): MyViewHolder = MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false))

    // Jumlah item yang akan ditampilkan
    override fun getItemCount(): Int = data.size

    // terusan dari onCreateView untuk dapat berinteraksi dengan tampilan
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(data[position])
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val nama = itemView.txtNama
        val des = itemView.txtDes

        fun bind(get: Barang) {
            // set value array ke view
            nama.text = get.name
            des.text = get.desk
        }
    }
}