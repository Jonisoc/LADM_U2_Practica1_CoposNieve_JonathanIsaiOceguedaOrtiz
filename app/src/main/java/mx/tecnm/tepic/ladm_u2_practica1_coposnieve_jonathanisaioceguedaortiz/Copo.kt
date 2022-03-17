package mx.tecnm.tepic.ladm_u2_practica1_coposnieve_jonathanisaioceguedaortiz

import kotlin.random.Random

class Copo(lim:Int) {
    var posX = 0f
    var posY = 0f
    var aumY = 0f
    var radio = 0f
    val lim = lim

    init {
        posX = rand(1, 1080)
        posY = rand(-200, 1500)
        aumY = rand(5, lim)
        radio = aumY * 1.5f
    }

    private fun rand(limi:Int, lims:Int): Float {
        return Random.nextInt(limi, lims).toFloat()
    }
}