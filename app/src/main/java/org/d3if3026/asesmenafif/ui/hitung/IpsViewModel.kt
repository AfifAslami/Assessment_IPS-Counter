package org.d3if3026.asesmenafif.ui.hitung

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.d3if3026.asesmenafif.db.IpsDao
import org.d3if3026.asesmenafif.db.IpsEntity
import org.d3if3026.asesmenafif.model.HasilIps
import org.d3if3026.asesmenafif.model.KategoriIps
import org.d3if3026.asesmenafif.model.hitungIps

class IpsViewModel(private val db: IpsDao) : ViewModel() {

    private val hasilIps = MutableLiveData<HasilIps?>()


    fun hitungIps(
        mk: String,
        mk2: String,
        mk3: String,
        mk4: String,
        sks: Float,
        sks2: Float,
        sks3: Float,
        sks4: Float,
        nilai: Float,
        nilai2: Float,
        nilai3: Float,
        nilai4: Float
    ) {

        val dataIps = IpsEntity(
            mk = mk,
            mk2 = mk2,
            mk3 = mk3,
            mk4 = mk4,

            sks = sks,
            sks2 = sks2,
            sks3 = sks3,
            sks4 = sks4,

            nilai = nilai,
            nilai2 = nilai2,
            nilai3 = nilai3,
            nilai4 = nilai4
        )
        hasilIps.value = dataIps.hitungIps()

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                db.insert(dataIps)
            }
        }
    }

    fun getHasilIps(): LiveData<HasilIps?> = hasilIps


}
