package com.example.encuesta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.security.identity.PersonalizationData
import android.widget.SeekBar
import com.example.encuesta.databinding.ActivityMainBinding
import modelo.Especialidad
import modelo.Persona

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var nombre:String=""
        var horas:String=""
        var SO:String=""
        val contador:Int=0
        val persona:Persona
        val especialidades= ArrayList<Especialidad>()
       nombre=binding.txtNombre.text.toString()
        if (binding.rbLinux.isChecked){
            SO="LINUX"
        }else if (binding.rbMac.isChecked){
            SO="MAC"
        }else if (binding.rbWindows.isChecked){
            SO="WINDOWS"
        }else{
            SO=""
        }
        if(binding.cbASIR.isChecked){
            especialidades.add(Especialidad.ASIR)

        }
        if(binding.cbDAM.isChecked){
            especialidades.add(Especialidad.DAM)
        }
        if (binding.cbDAW.isChecked){
            especialidades.add(Especialidad.DAW)
        }


            var progreso =binding.sbHorasEstudio.progress /10

            binding.txtHoras.setText((progreso.toString()))
        horas=progreso.toString()

persona=Persona(nombre, especialidades, SO , horas)
        binding.btnResumen.setOnClickListener {
            binding.multiLine.setText(nombre+" "+SO+" "+horas)
        }

    }

}


