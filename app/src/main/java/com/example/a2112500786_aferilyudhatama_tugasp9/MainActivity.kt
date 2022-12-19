package com.example.a2112500786_aferilyudhatama_tugasp9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    var nilaiPresensi: Int? = null
    var nilaiTugas: Int? = null
    var nilaiUts: Int? = null
    var nilaiUas: Int? = null
    var Grade: Char? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nim = findViewById<EditText>(R.id.nim)
        val nama = findViewById<EditText>(R.id.nama)
        val rgProgramStudi = findViewById<RadioGroup>(R.id.rgProgramStudi)
        val cbNetworking = findViewById<CheckBox>(R.id.cbNetworking)
        val cbWebApps = findViewById<CheckBox>(R.id.cbWebApps)
        val cbMobileApps = findViewById<CheckBox>(R.id.cbMobileApps)
        val cbCyberSecurity = findViewById<CheckBox>(R.id.cbCyberSecurity)
        val nilaiPresensi = findViewById<EditText>(R.id.nilaiPresensi)
        val nilaiTugas = findViewById<EditText>(R.id.nilaiTugas)
        val nilaiUts = findViewById<EditText>(R.id.nilaiUts)
        val nilaiUas = findViewById<EditText>(R.id.nilaiUas)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)
//        val vHasil = findViewById<TextView>(R.id.vHasil)
//        val vGrade = findViewById<TextView>(R.id.vGrade)
//        val btnHasil = findViewById<Button>(R.id.btnHasil)


        btnSubmit.setOnClickListener {
            val nim = nim.text.toString()

            val nama = nama.text.toString()

            val checkSistemId = rgProgramStudi.checkedRadioButtonId
            val sistemOperasi = findViewById<RadioButton>(checkSistemId)
            val programStudi = "${sistemOperasi.text}"

            val Networking = cbNetworking.isChecked
            val WebApps = cbWebApps.isChecked
            val MobileApps = cbMobileApps.isChecked
            val CyberSecurity = cbCyberSecurity.isChecked
            val skill = (if(Networking)"Networking\n" else "")+
                    (if(WebApps)"Web Application\n" else "")+
                    (if(MobileApps)"Mobile Application\n" else "")+
                    (if(CyberSecurity)"Cyber Security" else "")

            val nilaiPresensi = nilaiPresensi.text.toString().toInt()
            val nilaiTugas = nilaiTugas.text.toString().toInt()
            val nilaiUts = nilaiUts.text.toString().toInt()
            val nilaiUas = nilaiUas.text.toString().toInt()
            val empat = 4
            val nilaiProses = nilaiPresensi + nilaiTugas + nilaiUts + nilaiUas
            val nilaiAkhir = nilaiProses/empat
            val HasilAkhir = nilaiAkhir.toString()

            if (nilaiAkhir >= 81 && nilaiAkhir <=100){
                Grade = 'A'
            }
            else if (nilaiAkhir >= 61 && nilaiAkhir < 80){
                Grade = 'B'
            }
            else if (nilaiAkhir > 41 && nilaiAkhir < 60){
                Grade = 'C'
            }
            else if (nilaiAkhir > 21 && nilaiAkhir < 40){
                Grade = 'D'
            }
            else if (nilaiAkhir > 0 && nilaiAkhir <= 20){
                Grade = 'E'
            }
            val nilaiGrade = Grade
            val HasilGrade = nilaiGrade.toString()

            Intent(this, MainActivity2::class.java).also{
                it.putExtra("NIM",nim)
                it.putExtra("Nama",nama)
                it.putExtra("ProgramStudi",programStudi)
                it.putExtra("Skill",skill)
                it.putExtra("Nilai",HasilAkhir)
                it.putExtra("Grade",HasilGrade)
                startActivity(it)
            }
        }

//        btnHasil.setOnClickListener {
//            val nilaiPresensi = nilaiPresensi.text.toString().toInt()
//            val nilaiTugas = nilaiTugas.text.toString().toInt()
//            val nilaiUts = nilaiUts.text.toString().toInt()
//            val nilaiUas = nilaiUas.text.toString().toInt()
//            val empat = 4
//
//            val nilaiProses = nilaiPresensi + nilaiTugas + nilaiUts + nilaiUas
//            val nilaiAkhir = nilaiProses/empat
//            vHasil.setText("$nilaiAkhir")
//
//            if (nilaiAkhir >= 81 && nilaiAkhir <=100){
//                Grade = 'A'
//            }
//            else if (nilaiAkhir >= 61 && nilaiAkhir < 80){
//                Grade = 'B'
//            }
//            else if (nilaiAkhir > 41 && nilaiAkhir < 60){
//                Grade = 'C'
//            }
//            else if (nilaiAkhir > 21 && nilaiAkhir < 40){
//                Grade = 'D'
//            }
//            else if (nilaiAkhir > 0 && nilaiAkhir <= 20){
//                Grade = 'E'
//            }
//            vGrade.setText("$Grade")
//        }

    }
}