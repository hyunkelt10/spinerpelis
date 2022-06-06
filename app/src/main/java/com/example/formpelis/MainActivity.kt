package com.example.formpelis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.formpelis.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var b:ActivityMainBinding
    private var year = "2000"
    private var tipo = "Serie"
    private var cat = mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)

        getSpinner(b.spYear)

        b.rbSerie.setOnClickListener { tipo = "Serie" }
        b.rbPelicula.setOnClickListener { tipo = "Película" }

        b.btnSend.setOnClickListener { getAndSend() }
    }
    fun getAndSend(){
        val intentResult = Intent(this, ResultActivity::class.java)
        //intentResult.putExtra("COVER", b.ivCover.src)
        intentResult.putExtra("TITULO", b.etTitulo.text.toString())
        intentResult.putExtra("YEAR", year)
        intentResult.putExtra("TIPO", tipo)
        intentResult.putExtra("CATEGORIA", cat.toString())
        startActivity(intentResult)
    }
    fun getSpinner(spinner: Spinner){
        var userSelect = ""
        val adaptador: ArrayAdapter<*> = ArrayAdapter.createFromResource(this, R.array.Year,
            android.R.layout.simple_spinner_item)
        spinner.adapter = adaptador
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                userSelect = parent?.getItemAtPosition(position).toString()
                Toast.makeText(this@MainActivity, userSelect, Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                userSelect = "No ha habido selección"
                Toast.makeText(this@MainActivity, userSelect, Toast.LENGTH_SHORT).show()
            }
        }
        //Sustituir 'year' por la variable global donde se recoge el valor
        year = userSelect
    }
    fun onCheckBoxClicked(view: View){
        if (view is CheckBox) {
            val checked: Boolean = view.isChecked

            when (view.id) {
                R.id.ckChild -> { if (checked) {
                    checkCategory(b.ckChild.text.toString())
                } else {
                    unCheckCategory(b.ckChild.text.toString())
                }
                }
                R.id.ckSciFi -> { if (checked) {
                    checkCategory(b.ckSciFi.text.toString())
                } else {
                    unCheckCategory(b.ckSciFi.text.toString())
                }
                }
                R.id.ckTerror -> { if (checked) {
                    checkCategory(b.ckTerror.text.toString())
                } else {
                    unCheckCategory(b.ckTerror.text.toString())
                }
                }
                R.id.ckThriller -> { if (checked) {
                    checkCategory(b.ckThriller.text.toString())
                } else {
                    unCheckCategory(b.ckThriller.text.toString())
                }
                }
                R.id.ckFantasy -> { if (checked) {
                    checkCategory(b.ckFantasy.text.toString())
                } else {
                    unCheckCategory(b.ckFantasy.text.toString())
                }
                }
                R.id.ckHumour -> { if (checked) {
                    checkCategory(b.ckHumour.text.toString())
                } else {
                    unCheckCategory(b.ckHumour.text.toString())
                }
                }
                R.id.ckAnimation -> { if (checked) {
                    checkCategory(b.ckAnimation.text.toString())
                } else {
                    unCheckCategory(b.ckAnimation.text.toString())
                }
                }
                R.id.ckDrama -> { if (checked) {
                    checkCategory(b.ckDrama.text.toString())
                } else {
                    unCheckCategory(b.ckDrama.text.toString())
                }
                }
                R.id.ckSpanish -> { if (checked) {
                    checkCategory(b.ckSpanish.text.toString())
                } else {
                    unCheckCategory(b.ckSpanish.text.toString())
                }
                }

            }
        }
    }
    fun checkCategory(str:String){
        if (!cat.contains(str)) { cat.add(str) }
    }
    fun unCheckCategory(str:String){
        if (cat.contains(str)) { cat.remove(str) }
    }

    fun msj(str:String){
        Toast.makeText(this@MainActivity, str, Toast.LENGTH_SHORT).show()
    }

}