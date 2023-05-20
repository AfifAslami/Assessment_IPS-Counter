package org.d3if3026.asesmenafif.ui.histori

import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.d3if3026.asesmenafif.R
import org.d3if3026.asesmenafif.databinding.HistoriItemBinding
import org.d3if3026.asesmenafif.db.IpsEntity
import org.d3if3026.asesmenafif.model.KategoriIps
import org.d3if3026.asesmenafif.model.hitungIps
import java.text.SimpleDateFormat
import java.util.*

class HistoriAdapter: ListAdapter<IpsEntity, HistoriAdapter.ViewHolder>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK =
            object : DiffUtil.ItemCallback<IpsEntity>() {
                override fun areItemsTheSame(oldData: IpsEntity, newData: IpsEntity): Boolean {
                    return oldData.id == newData.id
                }

                override fun areContentsTheSame(oldData: IpsEntity, newData: IpsEntity): Boolean {
                    return oldData == newData
                }
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = HistoriItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(private val binding: HistoriItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val dateFormatter = SimpleDateFormat("dd MMMM yyyy", Locale("id", "ID"))


        fun bind(item: IpsEntity) = with(binding) {
            val hasilIps = item.hitungIps()
            kategoriTextView.text = hasilIps.kategori.toString().substring(0, 1)
            val colorRes = when (hasilIps.kategori) {
                KategoriIps.KURANG -> R.color.kurang
                KategoriIps.CUKUP -> R.color.cukup
                else -> R.color.tinggi
            }
            val circleBg = kategoriTextView.background as GradientDrawable
            circleBg.setColor(ContextCompat.getColor(root.context, colorRes))

            tanggalTextView.text = dateFormatter.format(Date(item.tanggal))
            ipsTextView.text = root.context.getString(
                R.string.hasil_x,
                hasilIps.ips, hasilIps.kategori.toString()
            )
        }
    }
}