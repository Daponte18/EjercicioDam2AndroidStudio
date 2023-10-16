package com.example.formulario2activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.voice.VoiceInteractionSession.ActivityId
import android.widget.Toast
import com.example.formulario2activitys.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var listaUsuario=ArrayList<Usuario>()
        var contador:Int=0
        var nombre:String=""
        var apellido:String=""
        var correo:String=""
        var DNI:String=""
        var contrasena:String=""

        binding.btnContinuar.setOnClickListener {
            if (binding.txtNombre.text.toString().isBlank()){
                Toast.makeText(this,"EL NOMBRE ESTÁ VACÍO",Toast.LENGTH_SHORT).show()
            }else{
                nombre=binding.txtNombre.text.toString()
            }
            if (binding.txtApellido.text.toString().isBlank()){
                Toast.makeText(this,"EL APELLIDO ESTÁ VACÍO",Toast.LENGTH_SHORT).show()
            }else{
                apellido=binding.txtApellido.text.toString()
            }
            if (binding.txtCorreo.text.toString().isBlank()){
                Toast.makeText(this,"EL CORREO ESTÁ VACÍO",Toast.LENGTH_SHORT).show()
            }else{
                correo=binding.txtCorreo.text.toString()
            }

            if (binding.txtConfirmarcontraseA.text.toString().isBlank() || binding.txtcontraseA.text.toString().isBlank()){
                Toast.makeText(this,"NO PUEDES DEJAR LA CONTRASEÑA VACÍA",Toast.LENGTH_SHORT).show()
            }else{
                if (binding.txtcontraseA.text.toString().equals(binding.txtConfirmarcontraseA.text.toString()) && binding.txtcontraseA.text.toString().length >= 9){
                    contrasena=binding.txtcontraseA.text.toString()
                }else{
                    Toast.makeText(this,"LAS CONTRASEÑAS NO SON ERRONEAS",Toast.LENGTH_SHORT).show()
                }
            }
            if (binding.txtDNI.text.toString().isBlank()){
                Toast.makeText(this,"EL DNI ESTÁ VACÍO",Toast.LENGTH_SHORT).show()
            }else {
                DNI = binding.txtDNI.text.toString()

                for (usuarios in listaUsuario) {
                    if (usuarios.dni == binding.txtDNI.text.toString()) {
                        contador = contador + 1
                    }

                }
            }
            if (contador==0){
                val usuario = Usuario(nombre, apellido, correo, DNI, contrasena)
                listaUsuario.add(usuario)

            }else {

                Toast.makeText(this,"NO SE PUEDE REGISTRAR YA EXISTE UN USUARIO CON ESE DNI",Toast.LENGTH_SHORT).show()

            }
            var miIntent: Intent = Intent(this, MainActivity2::class.java)

            miIntent.putExtra("Usuarios", listaUsuario)
            miIntent.putExtra("DNI",binding.txtDNI.text.toString())


            startActivity(miIntent)
            binding.txtNombre.text.clear()
            binding.txtApellido.text.clear()
            binding.txtDNI.text.clear()
            binding.txtCorreo.text.clear()
            binding.txtConfirmarcontraseA.text.clear()
            binding.txtcontraseA.text.clear()

        }




    }

}