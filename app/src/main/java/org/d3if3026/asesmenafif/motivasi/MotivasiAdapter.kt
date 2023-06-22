package org.d3if3026.mobpro1.ui.main


import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.d3if3026.asesmenafif.R
import org.d3if3026.asesmenafif.databinding.ListMotivasiBinding
import org.d3if3026.asesmenafif.model.HasilMotivasi
import org.d3if3026.asesmenafif.network.IpsApi

class MotivasiAdapter : RecyclerView.Adapter<MotivasiAdapter.ViewHolder>() {

    private val data = mutableListOf<HasilMotivasi>()
    fun updateData(newData: List<HasilMotivasi>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }

    class ViewHolder(
        private val binding: ListMotivasiBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(motivasi: HasilMotivasi) = with(binding) {
            motivasiText.text = motivasi.judul
            keteranganText.text = motivasi.keterangan
            Glide.with(imageView.context)
                .load(IpsApi.getMotivasiUrl(motivasi.image_id))
                .error(R.drawable.baseline_broken_image_24)
                .into(imageView)


            root.setOnClickListener {
                val message = root.context.getString(R.string.message, motivasi.judul)
                Toast.makeText(root.context, message, Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListMotivasiBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }
}