package org.d3if3026.asesmenafif.ui.histori

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.d3if3026.asesmenafif.db.IpsDao

class HistoriViewModel(private val db: IpsDao) : ViewModel() {
    val data = db.getLastIps()
    fun hapusData() = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            db.clearData()
        }
    }
}