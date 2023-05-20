package org.d3if3026.asesmenafif.ui.hitung

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.d3if3026.asesmenafif.db.IpsDao

class IpsViewModelFactory(
    private val db: IpsDao
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(IpsViewModel::class.java)) {
            return IpsViewModel(db) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}