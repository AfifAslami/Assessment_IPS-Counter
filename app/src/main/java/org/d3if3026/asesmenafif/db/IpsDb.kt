package org.d3if3026.asesmenafif.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [IpsEntity::class], version = 1, exportSchema = false)
abstract class IpsDb : RoomDatabase() {
    abstract val dao: IpsDao
    companion object {
        @Volatile
        private var INSTANCE: IpsDb? = null
        fun getInstance(context: Context): IpsDb {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        IpsDb::class.java,
                        "ips.db"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}