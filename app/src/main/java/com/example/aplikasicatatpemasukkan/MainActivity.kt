package com.example.aplikasicatatpemasukkan

import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Ambil referensi dari view di layout
        val etAmount = findViewById<EditText>(R.id.etAmount)
        val etDate = findViewById<EditText>(R.id.etDate)
        val etReason = findViewById<EditText>(R.id.etReason)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)
        val dataContainer = findViewById<LinearLayout>(R.id.dataContainer)

        // Aksi ketika tombol submit ditekan
        btnSubmit.setOnClickListener {
            // Ambil data dari inputan
            val amount = etAmount.text.toString()
            val date = etDate.text.toString()
            val reason = etReason.text.toString()

            // Pastikan inputan tidak kosong
            if (amount.isNotEmpty() && date.isNotEmpty() && reason.isNotEmpty()) {
                // Buat layout baru untuk menampilkan data yang disubmit
                val newEntry = LinearLayout(this)
                newEntry.orientation = LinearLayout.VERTICAL
                newEntry.setPadding(16, 16, 16, 16)
                newEntry.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white))
                newEntry.layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                ).apply {
                    setMargins(0, 10, 0, 10) // Atur margin atas-bawah antar entry
                }

                // TextView untuk tanggal
                val textViewDate = TextView(this)
                textViewDate.text = date
                textViewDate.textSize = 10f

                // TextView untuk jumlah uang
                val textViewAmount = TextView(this)
                textViewAmount.text = amount
                textViewAmount.textSize = 24f
                textViewAmount.setTextColor(ContextCompat.getColor(this, android.R.color.black))
                textViewAmount.setTypeface(null, android.graphics.Typeface.BOLD)
                textViewAmount.setTextColor(ContextCompat.getColor(this, R.color.my_custom_color))

                // TextView untuk tujuan pengeluaran
                val textViewReason = TextView(this)
                textViewReason.text = reason
                textViewReason.textSize = 18f
                textViewReason.setTextColor(ContextCompat.getColor(this, android.R.color.black))

                // Tambahkan TextView ke dalam layout baru
                newEntry.addView(textViewDate)
                newEntry.addView(textViewAmount)
                newEntry.addView(textViewReason)

                // Tambahkan layout baru ke dalam container
                dataContainer.addView(newEntry)

                // Kosongkan input setelah submit
                etAmount.text.clear()
                etDate.text.clear()
                etReason.text.clear()
            }
        }
    }
}
