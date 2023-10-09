package com.example.variosactivivtycondatos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.variosactivivtycondatos.databinding.ActivityMainBinding
import com.example.variosactivivtycondatos.databinding.ActivityVentana2Binding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.boton.setOnClickListener {

            cambiarVentana()


        }
    }

    private fun cambiarVentana() {
       // lateinit var binding: ActivityVentana2Binding

        //binding=ActivityVentana2Binding.inflate(layoutInflater)
        //setContentView(binding.root)
        var miIntent: Intent =Intent(this, Ventana2::class.java)
        startActivity(miIntent)

    }


}