package com.example.encuesta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import android.widget.Toast
import com.example.encuesta.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
var contador=1
        binding.multiLine.visibility=View.INVISIBLE
        binding.sbHorasEstudio.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar, progress: Int, fromUser: Boolean) {

                var progreso = binding.sbHorasEstudio.progress

                binding.txtHoras.setText((progreso.toString()))
            }

            override fun onStartTrackingTouch(seek: SeekBar) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        }


        )
        binding.btnValidar.setOnClickListener {
            val nombre:String
            var especialidad:String=""
            val lista=ArrayList<String>()

            if (binding.swAnonimo.isChecked){
                nombre="ANONIMO"
            }else{
                nombre=binding.txtNombre.text.toString()
                if (binding.txtNombre.text.toString().isBlank()){
                    Toast.makeText(this,"EL NOMBRE NO ESTA RELLENO",Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
            }
            if (binding.rbMac.isChecked) {
                especialidad = "MAC"
            } else if (binding.rbWindows.isChecked) {
                especialidad = "WINDOWS"
            } else if (binding.rbLinux.isChecked) {
                especialidad = "LINUX"
            }
            if (binding.cbDAM.isChecked){
                lista.add("DAM")
            }
            if (binding.cbASIR.isChecked){
                lista.add("ASIR")
            }
            if (binding.cbDAW.isChecked){
                lista.add("DAW")
            }

            binding.multiLine.append(contador.toString() +" "+ nombre +" "+especialidad+" "+lista+" "+binding.txtHoras.text.toString()+"\n")
            contador++
            binding.Contador.setText(contador.toString())
            binding.rbMac.isChecked = false
            binding.rbLinux.isChecked = false
            binding.rbWindows.isChecked = false
            binding.cbASIR.isChecked=false
            binding.cbDAM.isChecked=false
            binding.cbDAW.isChecked=false
            binding.txtNombre.text.clear()
            binding.swAnonimo.isChecked=false
        }
        binding.btnResumen.setOnClickListener {

            binding.multiLine.visibility=View.VISIBLE

        }
        binding.btnReiniciar.setOnClickListener {

            binding.rbMac.isChecked = false
            binding.rbLinux.isChecked = false
            binding.rbWindows.isChecked = false
            binding.cbASIR.isChecked=false
            binding.cbDAM.isChecked=false
            binding.cbDAW.isChecked=false
            binding.txtNombre.text.clear()
            binding.swAnonimo.isChecked=false
            binding.multiLine.text.clear()

        }
        binding.btnCuantas.setOnClickListener {

Toast.makeText(this,"EN LA ENCUESTA HAN RESPONDIDO "+binding.Contador.text.toString()+" PERSONAS",Toast.LENGTH_SHORT ).show()
        }



    }
}













