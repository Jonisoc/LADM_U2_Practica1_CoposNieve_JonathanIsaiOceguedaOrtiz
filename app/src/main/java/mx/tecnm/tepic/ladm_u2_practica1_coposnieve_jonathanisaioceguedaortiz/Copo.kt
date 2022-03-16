package mx.tecnm.tepic.ladm_u2_practica1_coposnieve_jonathanisaioceguedaortiz

import kotlin.random.Random

class Copo(lim:Int) {
    var posX = Random.nextInt(1, 1080).toFloat()
    var posY = Random.nextInt(-200, 1000).toFloat()
    var aumY = Random.nextInt(5,lim).toFloat()
    var radio = aumY * 1.5f
}