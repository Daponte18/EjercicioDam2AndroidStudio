package com.example.formulario2activitys

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.formulario2activitys.databinding.ActivityVentana2Binding
import android.content.Intent


class MainActivity2: AppCompatActivity()  {


    lateinit var binding: ActivityVentana2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVentana2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val listaUsuario = intent.getSerializableExtra("Usuarios") as ArrayList<Usuario>
        val dni=intent.getStringExtra("DNI")
        var cadena: String =""
        var i:Int=1
    for (usuario in listaUsuario){

         if (usuario.dni.equals(dni)) {
             binding.txtApellidos.setText(usuario.apellido)
             binding.txtCorreoo.setText(usuario.correo)
             binding.txtname.setText(usuario.nombre)
             binding.txtcontra.setText(usuario.contrasena)
             binding.txtDni.setText(usuario.dni)

         }

        binding.editTextTextMultiLine.append(usuario.toString()+"\n")


    }
        for (usuario in listaUsuario){

        }




    binding.button.setOnClickListener {

        finish()
    }
    }
}