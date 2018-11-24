package me.firdaus1453.samplecoroutineroom.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

// Membutuhkan annotation menjadi sebagai untuk dapat menggunakan table yang kita inginkan
@Database(
    entities = arrayOf(Barang::class),
    version = 1
) // Database dengan memiliki entities/table, kalau ingin menambah table bisa ditambahkan koma, version untuk apabila ada perubahaan
abstract class AppDatabase : RoomDatabase() {

    abstract fun barangDao(): BarangDao

    // Membuat public static
    companion object {

        var INSTANCE : AppDatabase? = null

        // Membuat function return
        fun getAppDatabase(context: Context): AppDatabase {

            INSTANCE = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "db_barang")
                .allowMainThreadQueries() // Mengijinkan ke mainthread
                .build()

            return INSTANCE as AppDatabase
        }
    }

}