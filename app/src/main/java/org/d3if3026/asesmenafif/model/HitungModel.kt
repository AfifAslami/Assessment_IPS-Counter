package org.d3if3026.asesmenafif.model

import org.d3if3026.asesmenafif.db.IpsEntity

fun IpsEntity.hitungIps(): HasilIps {

    val mutu = nilai * sks
    val mutu2 = nilai2 * sks2
    val mutu3 = nilai3 * sks3
    val mutu4 = nilai4 * sks4

    val sks_total = sks + sks2 + sks3 + sks4
    val nilai_total = mutu + mutu2 + mutu3 + mutu4
    val hasilAkhir = nilai_total / sks_total


    val kategori = when {
        hasilAkhir < 2 -> KategoriIps.KURANG
        hasilAkhir >= 3 -> KategoriIps.TINGGI
        else -> KategoriIps.CUKUP
    }
    return HasilIps(hasilAkhir, kategori)
}
