package me.firdaus1453.samplecoroutineroom.database

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

// TODO 1 Membuat nama table menggunakan annotation Entity
@Entity(tableName = "barang")
class Barang {

    // TODO 2 Membuat field id
    @PrimaryKey(autoGenerate = true) // setting primary key
    var id: Int = 0

    // TODO 3 Membuat kolom nama
    @ColumnInfo(name = "name") // nama kolom
    var name : String? = null

    // TODO 4 Membuat kolom deskripsi
    @ColumnInfo(name = "deskripsi") // nama kolom
    var desk : String? = null

}