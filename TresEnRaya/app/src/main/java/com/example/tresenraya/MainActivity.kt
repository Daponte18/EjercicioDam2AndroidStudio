package com.example.tresenraya

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.tresenraya.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var mediaPlayer: MediaPlayer
    lateinit var mediaPlayer1: MediaPlayer
    lateinit var mediaPlayer2: MediaPlayer
    var turno: Int = 1
    var partidaFinalizada = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mediaPlayer = MediaPlayer.create(this, R.raw.mariomusic)
        mediaPlayer.start()

        val listaDeBotones = listOf(
            listOf(binding.img1x1, binding.img1x2, binding.img1x3),
            listOf(binding.img2x1, binding.img2x2, binding.img2x3),
            listOf(binding.img3x1, binding.img3x2, binding.img3x3)


        )

        val listaDeOpc = arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(0, 0, 0),
            intArrayOf(0, 0, 0),
        )

        var turnos: Int = 0





        for (i in 0 until 3) {
            for (j in 0 until 3) {
                val boton = listaDeBotones[i][j]

                boton.setOnClickListener {
                    if (!partidaFinalizada) {
                        if (turnos == 1) {

                            if (listaDeOpc[i][j] == 0) {
                                listaDeOpc[i][j] = 1
                                boton.setImageResource(R.drawable.mariotu)
                                mediaPlayer2 = MediaPlayer.create(this, R.raw.tubo)
                                mediaPlayer2.start()
                                turno++

                            }
                        } else {
                            if (listaDeOpc[i][j] == 0) {
                                listaDeOpc[i][j] = 2
                                boton.setImageResource(R.drawable.luigitu)
                                mediaPlayer2 = MediaPlayer.create(this, R.raw.tubo)
                                mediaPlayer2.start()
                                turno++
                            }

                        }


                        if (turno % 2 == 0) {
                            turnos = 1
                            binding.imgTurnos.setImageResource(R.drawable.mario)
                        } else {
                            turnos = 2
                            binding.imgTurnos.setImageResource(R.drawable.luigi)

                        }

                        val ganador = compro(listaDeOpc)
                        if (ganador == 1) {
                            mediaPlayer1 = MediaPlayer.create(this, R.raw.mario)
                            mediaPlayer1.start()
                            Toast.makeText(this,"EL JUGADOR 1 HA SIDO EL GANADOR", Toast.LENGTH_SHORT).show()
                            mediaPlayer1 = MediaPlayer.create(this, R.raw.ganar)
                            mediaPlayer1.start()
                            binding.txtConGanadasJ1.setText(
                                (binding.txtConGanadasJ1.text.toString().toInt() + 1).toString()
                            )
                            partidaFinalizada = true

                        } else if (ganador == 2) {
                            mediaPlayer1 = MediaPlayer.create(this, R.raw.luigi)
                            mediaPlayer1.start()
                            Toast.makeText(this,"EL JUGADOR 2 HA SIDO EL GANADOR",Toast.LENGTH_SHORT).show()
                            mediaPlayer1 = MediaPlayer.create(this, R.raw.ganar)
                            mediaPlayer1.start()
                            binding.txtConGanadasJ2.setText((binding.txtConGanadasJ2.text.toString().toInt() + 1).toString())
                            partidaFinalizada = true


                        }
                        var contador: Int = 0
                        for (m in 0 until 3) {
                            for (ñ in 0 until 3) {

                                if (listaDeOpc[m][ñ] != 0) {
                                    contador++
                                }
                            }

                        }
                        if (contador == 9) {
                            partidaFinalizada = true
                            Toast.makeText(this, "EMPATE", Toast.LENGTH_SHORT).show()
                            mediaPlayer1 = MediaPlayer.create(this, R.raw.empate)
                            mediaPlayer1.start()
                        }


                    }

                }


            }
        }
        binding.btnReiniciar.setOnClickListener {
            for (i in 0 until 3) {
                for (j in 0 until 3) {

                    listaDeOpc[i][j] = 0
                    listaDeBotones[i][j].setImageResource(R.drawable.tuberia)
                    partidaFinalizada = false


                }
            }
        }

    }


}

fun compro(listaDeOpc: Array<IntArray>): Int {
    var ganador = 0
    for (i in 0 until 3) {
        if (listaDeOpc[i][0] == 1 && listaDeOpc[i][1] == 1 && listaDeOpc[i][2] == 1 ||
            listaDeOpc[0][i] == 1 && listaDeOpc[1][i] == 1 && listaDeOpc[2][i] == 1
        ) {
            ganador = 1
        } else if (listaDeOpc[i][0] == 2 && listaDeOpc[i][1] == 2 && listaDeOpc[i][2] == 2 ||
            listaDeOpc[0][i] == 2 && listaDeOpc[1][i] == 2 && listaDeOpc[2][i] == 2
        ) {
            ganador = 2
        }
    }


    if (listaDeOpc[0][0] == 1 && listaDeOpc[1][1] == 1 && listaDeOpc[2][2] == 1 ||
        listaDeOpc[0][2] == 1 && listaDeOpc[1][1] == 1 && listaDeOpc[2][0] == 1
    ) {
        ganador = 1
    } else if (listaDeOpc[0][0] == 2 && listaDeOpc[1][1] == 2 && listaDeOpc[2][2] == 2 ||
        listaDeOpc[0][2] == 2 && listaDeOpc[1][1] == 2 && listaDeOpc[2][0] == 2
    ) {
        ganador = 2
    }
//JAIMEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE                                              HOLA

    return ganador
}





















































































//ESTAMOS ACTIVOS