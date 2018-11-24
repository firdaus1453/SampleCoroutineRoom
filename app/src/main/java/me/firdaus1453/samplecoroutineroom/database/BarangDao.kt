package me.firdaus1453.samplecoroutineroom.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface BarangDao {

    // TODO Membuat Query untuk manipulasi data dari sqlite using room menggunakan annotation perama @Dao

    // TODO Membuat function insert
    @Insert
    fun insertAll(barang : Barang) // Class barang sebagai enkapluation atau getter dan setter

    // TODO Membuat delete
    @Delete
    fun delete(barang: Barang)

    // TODO membuat function get
    @get:Query("select * FROM barang") // nama barang ngambil dari nama kolom barang
    val allBarang : List<Barang>

    // Room adalah termasuk bagian arsitektur komponen
}