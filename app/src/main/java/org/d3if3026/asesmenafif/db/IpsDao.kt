package org.d3if3026.asesmenafif.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface IpsDao {
    @Insert
    fun insert(ips: IpsEntity)

    @Query("SELECT * FROM ips ORDER BY id DESC")
    fun getLastIps(): LiveData<List<IpsEntity>>

    @Query("DELETE FROM ips")
    fun clearData()
}