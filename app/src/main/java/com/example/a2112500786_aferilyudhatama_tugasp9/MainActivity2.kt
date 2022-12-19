package com.example.a2112500786_aferilyudhatama_tugasp9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val tmpNim = findViewById<TextView>(R.id.tmpNim)
        val tmpNama = findViewById<TextView>(R.id.tmpNama)
        val tmpPS = findViewById<TextView>(R.id.tmpPS)
        val tmpSkill = findViewById<TextView>(R.id.tmpSkill)
        val tmpNA = findViewById<TextView>(R.id.tmpNA)
        val tmpGrade = findViewById<TextView>(R.id.tmpGrade)
        val btnBack = findViewById<Button>(R.id.btnBack)

        val nim = intent.getStringExtra("NIM")
        tmpNim.setText("$nim")

        val nama = intent.getStringExtra("Nama")
        tmpNama.setText("$nama")

        val programStudi = intent.getStringExtra("ProgramStudi")
        tmpPS.text = "$programStudi"

        val skill = intent.getStringExtra("Skill")
        tmpSkill.text = "$skill"

        val nilaiAkhir = intent.getStringExtra("Nilai")
        tmpNA.setText("$nilaiAkhir")

        val nilaiGrade = intent.getStringExtra("Grade")
        tmpGrade.setText("$nilaiGrade")

        btnBack.setOnClickListener {
            Intent(this, MainActivity::class.java).also {
                startActivity(it)
            }
        }

    }
}
