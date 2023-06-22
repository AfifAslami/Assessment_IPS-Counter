package org.d3if3026.asesmenafif.ui.hitung

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import org.d3if3026.asesmenafif.R
import org.d3if3026.asesmenafif.databinding.HitungFragmentBinding
import org.d3if3026.asesmenafif.db.IpsDb
import org.d3if3026.asesmenafif.model.HasilIps
import org.d3if3026.asesmenafif.model.KategoriIps

class HitungFragment : Fragment() {

    private lateinit var binding: HitungFragmentBinding
    private val viewModel: IpsViewModel by lazy {
        val db = IpsDb.getInstance(requireContext())
        val factory = IpsViewModelFactory(db.dao)
        ViewModelProvider(this, factory)[IpsViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = HitungFragmentBinding.inflate(layoutInflater, container, false)
        binding.hitungIps.setOnClickListener { hitungIps() }
        binding.sharebutton.setOnClickListener { shareData() }
        binding.buttonGroup.visibility = View.INVISIBLE
        setHasOptionsMenu(true)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.hitungIps.setOnClickListener { hitungIps() }
        binding.bersihButton.setOnClickListener { bersih() }

        binding.sharebutton.setOnClickListener { shareData() }

        viewModel.getHasilIps().observe(requireActivity(), { showResult(it) })

    }

    private fun shareData() {
        val message = getString(
            R.string.bagikan_template,
            binding.hasilIps.text,
            binding.KategoritextView.text
        )
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain").putExtra(Intent.EXTRA_TEXT, message)
        if (shareIntent.resolveActivity(
                requireActivity().packageManager
            ) != null
        ) {
            startActivity(shareIntent)
        }
    }


    private fun hitungIps() {

        val mk = binding.mk1Input.text.toString()
        val nilai = binding.nilai1Input.text.toString()
        val sks = binding.sks1Input.text.toString()
        if (TextUtils.isEmpty(mk) || TextUtils.isEmpty(sks) || TextUtils.isEmpty(nilai)) {
            Toast.makeText(context, R.string.validasi, Toast.LENGTH_LONG).show()
            return
        }

        val mk2 = binding.mk2Input.text.toString()
        val nilai2 = binding.nilai2Input.text.toString()
        val sks2 = binding.sks2Input.text.toString()
        if (TextUtils.isEmpty(mk2) || TextUtils.isEmpty(sks2) || TextUtils.isEmpty(nilai2)) {
            Toast.makeText(context, R.string.validasi2, Toast.LENGTH_LONG).show()
            return
        }

        val mk3 = binding.mk3Input.text.toString()
        val nilai3 = binding.nilai3Input.text.toString()
        val sks3 = binding.sks3Input.text.toString()
        if (TextUtils.isEmpty(mk3) || TextUtils.isEmpty(sks3) || TextUtils.isEmpty(nilai3)) {
            Toast.makeText(context, R.string.validasi3, Toast.LENGTH_LONG).show()
            return
        }


        val mk4 = binding.mk4Input.text.toString()
        val nilai4 = binding.nilai4Input.text.toString()
        val sks4 = binding.sks4Input.text.toString()
        if (TextUtils.isEmpty(mk4) || TextUtils.isEmpty(sks4) || TextUtils.isEmpty(nilai4)) {
            Toast.makeText(context, R.string.validasi4, Toast.LENGTH_LONG).show()
            return
        }

        viewModel.hitungIps(
            mk.toString(),
            mk2.toString(),
            mk3.toString(),
            mk4.toString(),
            sks.toFloat(),
            sks2.toFloat(),
            sks3.toFloat(),
            sks4.toFloat(),
            nilai.toFloat(),
            nilai2.toFloat(),
            nilai3.toFloat(),
            nilai4.toFloat()
        )

    }

    private fun getKategoriLabel(kategori: KategoriIps): String {
        val stringRes = when (kategori) {
            KategoriIps.KURANG -> R.string.kurang
            KategoriIps.CUKUP -> R.string.cukup
            KategoriIps.TINGGI -> R.string.tinggi

        }
        return getString(stringRes)
    }

    private fun showResult(result: HasilIps?) {
        if (result == null) return

        binding.hasilIps.text = getString(R.string.hasil, result.ips)
        binding.KategoritextView.text = getString(
            R.string.kate_x, getKategoriLabel(result.kategori)
        )
        binding.buttonGroup.visibility = View.VISIBLE

    }

    private fun bersih() {

        var inputMk1 = binding.mk1Input
        var inputMk2 = binding.mk2Input
        var inputMk3 = binding.mk3Input
        var inputMk4 = binding.mk4Input


        var inputSks1 = binding.sks1Input
        var inputSks2 = binding.sks2Input
        var inputSks3 = binding.sks3Input
        var inputSks4 = binding.sks4Input

        var inputNilai1 = binding.nilai1Input
        var inputNilai2 = binding.nilai2Input
        var inputNilai3 = binding.nilai3Input
        var inputNilai4 = binding.nilai4Input

        var hasilIps = binding.hasilIps
        var kategori = binding.KategoritextView

        inputMk1.text = null
        inputMk2.text = null
        inputMk3.text = null
        inputMk4.text = null

        inputSks1.text = null
        inputSks2.text = null
        inputSks3.text = null
        inputSks4.text = null

        inputNilai1.text = null
        inputNilai2.text = null
        inputNilai3.text = null
        inputNilai4.text = null

        hasilIps.text = "0"
        kategori.text = "Kategori : ?"
        binding.buttonGroup.visibility = View.INVISIBLE
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_histori -> {
                findNavController().navigate(R.id.action_hitungFragment_to_historiFragment)
                return true
            }

            R.id.menu_about -> {
                findNavController().navigate(R.id.action_hitungFragment_to_aboutFragment)
                return true
            }
            R.id.menu_motivasi -> {
                findNavController().navigate(R.id.action_hitungFragment_to_motivasiFragment)
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }

}