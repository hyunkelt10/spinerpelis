package com.example.formpelis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.formpelis.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var b:ActivityMainBinding
    private var year = arrayOf("")
    private var tipo = "Serie"
    private var cat = mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)

        getSpinner(this, b.spYear, year, R.array.Year)

        b.rbSerie.setOnClickListener { tipo = "Serie" }
        b.rbPelicula.setOnClickListener { tipo = "Película" }

        b.btnSend.setOnClickListener { getAndSend() }
    }
    fun getAndSend(){
        val intentResult = Intent(this, ResultActivity::class.java)
        //intentResult.putExtra("COVER", b.ivCover.src)
        intentResult.putExtra("TITULO", b.etTitulo.text.toString())
        intentResult.putExtra("YEAR", year[0])
        intentResult.putExtra("TIPO", tipo)
        intentResult.putExtra("CATEGORIA", cat.toString())
        startActivity(intentResult)
    }

    fun onCheckBoxClicked(view: View){
        if (view is CheckBox) {
            val checked: Boolean = view.isChecked

            if (checked){
                cat.add(view.text.toString())
            } else {
                cat.remove(view.text.toString())
            }
        }
    }
    fun checkCategory(str:String){
        if (!cat.contains(str)) { cat.add(str) }
    }
    fun unCheckCategory(str:String){
        if (cat.contains(str)) { cat.remove(str) }
    }



}