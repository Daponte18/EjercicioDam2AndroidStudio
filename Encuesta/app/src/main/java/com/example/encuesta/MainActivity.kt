package com.example.encuesta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.security.identity.PersonalizationData
import android.widget.SeekBar
import android.widget.Toast
import com.example.encuesta.databinding.ActivityMainBinding
import modelo.Especialidad
import modelo.Persona

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    val persona:Persona
        val listaDeEsoecialidades:ArrayList<Especialidad>
        val nombre=binding.txtNombre.text.toString()

        binding.sbHorasEstudio.setOnSeekBarChangeListener(object:
            SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seek: SeekBar, progress: Int, fromUser: Boolean) {

                var progreso =binding.sbHorasEstudio.progress

                binding.txtHoras.setText((progreso.toString()))
            }
            override fun onStartTrackingTouch(seek: SeekBar) {

            }
            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        }


        )


binding.btnResumen.setOnClickListener {
    val hora=binding.txtHoras.text.toString()
    var SO:String
    val nombre=binding.txtNombre.text.toString()
    if (binding.rbMac.isChecked){
         SO="MAC"
    }else if (binding.rbLinux.isChecked){
         SO="LINUX"
    }else if (binding.rbWindows.isChecked){
         SO="WINDOWS"
    }else{
        SO=""
    }
    if(binding.cbDAW.isChecked){
        Especialidad.DAW.toString()

    }
    val cadena= nombre+" "+ hora+" " +" "+SO+""
    binding.multiLine.append(cadena+ "\n")

}




    }

}


