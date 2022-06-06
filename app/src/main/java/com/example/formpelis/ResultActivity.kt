package com.example.formpelis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.formpelis.databinding.ActivityResultBinding

/**
 * PUnto 1
 *  a) lasdkfjañs
 *
 * añsdkflajsd
 * asdfñlaksdjf
 * asdfkjasñdflkas
 * asdfñlkasjdfls
 *
 */

class ResultActivity : AppCompatActivity() {
    private lateinit var b:ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityResultBinding.inflate(layoutInflater)
        setContentView(b.root)
        val datos = intent.extras
        val op = arrayOf("")
        val marcas = arrayOf("Danone", "Adidas", "Nike")
        getSpinner(this,b.spnJoseAntonio,op,R.array.Year)
        val str = """   DATOS
            Título: ${datos?.get("TITULO")}
            Año: ${datos?.get("YEAR")}
            Tipo: ${datos?.get("TIPO")}
            Categorías: ${datos?.get("CATEGORIA")}
        """.trimIndent()
        msj(this,str,false)
        b.tvDatos.text = str
        b.btnVolver.setOnClickListener { onBackPressed() }
    }
}