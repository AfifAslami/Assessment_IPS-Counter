package org.d3if3026.asesmenafif.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ips")
data class IpsEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,
    var tanggal: Long = System.currentTimeMillis(),

    var mk: String,
    var mk2: String,
    var mk3: String,
    var mk4: String,

    var nilai: Float,
    var nilai2: Float,
    var nilai3: Float,
    var nilai4: Float,

    var sks: Float,
    var sks2: Float,
    var sks3: Float,
    var sks4: Float,
)