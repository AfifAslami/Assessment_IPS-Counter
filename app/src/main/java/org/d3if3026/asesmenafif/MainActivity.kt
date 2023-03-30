package org.d3if3026.asesmenafif

import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.d3if3026.asesmenafif.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.hitungIps.setOnClickListener { hitungIps() }
        binding.bersihButton.setOnClickListener { bersih() }
    }

//BESIH BUTTON
    fun bersih() {
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

    }

//PENGINPUTAN UTAMA & VALIDASI
    private fun hitungIps() {


        val mk = binding.mk1Input.text.toString()
        val nilai = binding.nilai1Input.text.toString()
        val sks = binding.sks1Input.text.toString()
        if (TextUtils.isEmpty(mk) || TextUtils.isEmpty(sks) || TextUtils.isEmpty(nilai)) {
            Toast.makeText(this, R.string.validasi, Toast.LENGTH_LONG).show()
            return
        }

        val mk2 = binding.mk2Input.text.toString()
        val nilai2 = binding.nilai2Input.text.toString()
        val sks2 = binding.sks2Input.text.toString()
        if (TextUtils.isEmpty(mk2) || TextUtils.isEmpty(sks2) || TextUtils.isEmpty(nilai2)) {
            Toast.makeText(this, R.string.validasi2, Toast.LENGTH_LONG).show()
            return
        }

        val mk3 = binding.mk3Input.text.toString()
        val nilai3 = binding.nilai3Input.text.toString()
        val sks3 = binding.sks3Input.text.toString()
        if (TextUtils.isEmpty(mk3) || TextUtils.isEmpty(sks3) || TextUtils.isEmpty(nilai3)) {
            Toast.makeText(this, R.string.validasi3, Toast.LENGTH_LONG).show()
            return
        }


        val mk4 = binding.mk4Input.text.toString()
        val nilai4 = binding.nilai4Input.text.toString()
        val sks4 = binding.sks4Input.text.toString()
        if (TextUtils.isEmpty(mk4) || TextUtils.isEmpty(sks4) || TextUtils.isEmpty(nilai4)) {
            Toast.makeText(this, R.string.validasi4, Toast.LENGTH_LONG).show()
            return
        }

//PEMBATASAN SKS & VALIDASI
        if (sks > "4") {
            Toast.makeText(this, R.string.validasi11, Toast.LENGTH_LONG).show()
            return
        }

        if (sks2 > "4") {
            Toast.makeText(this, R.string.validasi12, Toast.LENGTH_LONG).show()
            return
        }

        if (sks3 > "4") {
            Toast.makeText(this, R.string.validasi13, Toast.LENGTH_LONG).show()
            return
        }

        if (sks4 > "4") {
            Toast.makeText(this, R.string.validasi14, Toast.LENGTH_LONG).show()
            return
        }

//PENGCONVERTAN NILAI
        val grade = binding.nilai1Input.text.toString()
        val nilaiGrade = when (grade) {
            "A" -> "4"
            "B" -> "3"
            "C" -> "2"
            "D" -> "1"
            "E" -> "0"


            else -> "Masukan A-D memakai Huruf Kapital"
        }

        val grade2 = binding.nilai2Input.text.toString()
        val nilaiGrade2 = when (grade2) {
            "A" -> "4"
            "B" -> "3"
            "C" -> "2"
            "D" -> "1"
            "E" -> "0"

            else -> "Masukan A-D memakai Huruf Kapital"
        }

        val grade3 = binding.nilai3Input.text.toString()
        val nilaiGrade3 = when (grade3) {
            "A" -> "4"
            "B" -> "3"
            "C" -> "2"
            "D" -> "1"
            "E" -> "0"


            else -> "Masukan A-D memakai Huruf Kapital"
        }

        val grade4 = binding.nilai4Input.text.toString()
        val nilaiGrade4 = when (grade4) {
            "A" -> "4"
            "B" -> "3"
            "C" -> "2"
            "D" -> "1"
            "E" -> "0"

            else -> "Masukan A-D memakai Huruf Kapital"
        }

//PEMBATASAN NILAI & VALIDASI
        if (nilaiGrade > "4") {
            Toast.makeText(this, R.string.validasi21, Toast.LENGTH_LONG).show()
            return
        }

        if (nilaiGrade2 > "4") {
            Toast.makeText(this, R.string.validasi22, Toast.LENGTH_LONG).show()
            return
        }

        if (nilaiGrade3 > "4") {
            Toast.makeText(this, R.string.validasi23, Toast.LENGTH_LONG).show()
            return
        }

        if (nilaiGrade4 > "4") {
            Toast.makeText(this, R.string.validasi24, Toast.LENGTH_LONG).show()
            return
        }

//RUMUS
        val mutu = nilaiGrade.toFloat() * sks.toFloat()
        val mutu2 = nilaiGrade2.toFloat() * sks2.toFloat()
        val mutu3 = nilaiGrade3.toFloat() * sks3.toFloat()
        val mutu4 = nilaiGrade4.toFloat() * sks4.toFloat()

        val sks_total = sks.toFloat() + sks2.toFloat() + sks3.toFloat() + sks4.toFloat()
        val nilai_total = mutu.toFloat() + mutu2.toFloat() + mutu3.toFloat() + mutu4.toFloat()
        val hasil_ips = nilai_total.toFloat() / sks_total.toFloat()

        binding.hasilSks.text = getString(R.string.dari_fronttext, sks_total)
        binding.hasilIps.text = getString(R.string.ips_backtext, hasil_ips)


    }
}