package me.firdaus1453.samplecoroutineroom

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.Adapter
import kotlinx.android.synthetic.main.activity_list_barang.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import me.firdaus1453.samplecoroutineroom.adapter.ItemAdapter
import me.firdaus1453.samplecoroutineroom.database.AppDatabase
import me.firdaus1453.samplecoroutineroom.database.Barang
import org.jetbrains.anko.coroutines.experimental.bg

class ListBarangActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_barang)

        ambilData()
    }

    private fun ambilData() {

        async(UI) {

            val data = bg {
                // Insert table
                Log.i("cek","masuk ke bg ListBarangActivity")
                AppDatabase.getAppDatabase(this@ListBarangActivity)
                    .barangDao()
                    .allBarang
            }

            showData(data.await())
            Log.i("showData",data.toString())

        }
    }

    private fun showData(await: List<Barang>) {
        // Set adapter
        Log.i("showData",await.toString())
        val adapter = ItemAdapter(await)
        list.adapter = adapter
        list.layoutManager = LinearLayoutManager(this)
    }
}
