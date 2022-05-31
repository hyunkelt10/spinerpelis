package com.example.formpelis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.formpelis.databinding.ActivityResultBinding


class ResultActivity : AppCompatActivity() {
    private lateinit var b:ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityResultBinding.inflate(layoutInflater)
        setContentView(b.root)
        val datos = intent.extras
        b.tvDatos.text
        val str = """   DATOS
            Título: ${datos?.get("TITULO")}
            Año: ${datos?.get("YEAR")}
            Tipo: ${datos?.get("TIPO")}
            Categorías: ${datos?.get("CATEGORIA")}
        """.trimIndent()
        b.tvDatos.text = str
        b.btnVolver.setOnClickListener { onBackPressed() }
    }
}