package me.firdaus1453.samplecoroutineroom

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import me.firdaus1453.samplecoroutineroom.database.AppDatabase
import me.firdaus1453.samplecoroutineroom.database.Barang
import org.jetbrains.anko.coroutines.experimental.bg

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Kalau Async tidak ada return
        btnInsert.setOnClickListener {

            // check Edittext tidak boleh kosong
            if(itemNama.text.isNotEmpty() && itemDesk.text.isNotEmpty()){
                Log.i("cek","nama dan des ada isinya")

                // Syncrounus menunggu selesai tugas pertama baru bisa lanjut tugas selanjutnya
                // Kalau asyncrounus tugas bisa dilakukan berbarengan
                // Insert database
                async(UI){
                    bg {
                        Log.i("cek","masuk ke bg MainActivity")

                        // Ambil inputan user
                        val name = itemNama.text.toString()
                        val desk = itemDesk.text.toString()

                        val barang = Barang()
                        barang.name = name
                        barang.desk = desk
                        Log.i("cek",barang.name + barang.desk)

                        // Insert table
                        AppDatabase.getAppDatabase(this@MainActivity)
                            .barangDao()
                            .insertAll(barang)
                    }
                }
                // Berpindah halaman
                startActivity(Intent(this, ListBarangActivity::class.java))
            }
        }
    }
}
