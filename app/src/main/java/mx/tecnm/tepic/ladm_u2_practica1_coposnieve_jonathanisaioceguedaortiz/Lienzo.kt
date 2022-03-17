package mx.tecnm.tepic.ladm_u2_practica1_coposnieve_jonathanisaioceguedaortiz

import android.graphics.*
import android.graphics.Path.FillType
import android.view.View
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random


class Lienzo(este:MainActivity):View(este) {
    var este = este
    var Copos = Array<Copo>(50, {Copo(15)})
    var contador = 0
    var tiempo = 300

    override fun onDraw(c: Canvas) {
        super.onDraw(c)
        //Paint
        var p = Paint()
        val ancho = width.toFloat()
        val alto = height.toFloat()
        val piso = 1300f
        var color = Color.rgb(15, 18, 54)
        c.drawColor(color)

        //Terreno
        color = Color.rgb(180, 232, 212)
        p.color = color
        c.drawRect(0f, piso, ancho, alto, p)
        p.style = Paint.Style.FILL_AND_STROKE

        //Arboles
        color = Color.rgb(136, 0, 21)
        p.color = color
        c.drawRect(100f, piso - 450f, 250f, piso, p)
        c.drawRect(ancho - 80f, piso - 400f, ancho - 220f, piso, p)

        //Hojas arboles
        color = Color.rgb(45, 154, 45)
        p.color = color
        c.drawOval(10f, piso - 580f, 340f, piso - 420f, p)
        c.drawOval(ancho - 310f, piso - 510f, ancho + 10f, piso - 350f, p)

        color = Color.rgb(37, 125, 37)
        p.color = color
        c.drawOval(50f, piso - 670f, 300f, piso - 550f, p)
        c.drawOval(ancho - 270f, piso - 600f, ancho - 30f, piso - 480f, p)

        color = Color.rgb(25, 84, 25)
        p.color = color
        c.drawOval(80f, piso - 740f, 270f, piso - 650f, p)
        c.drawOval(ancho - 240f, piso - 670f, ancho - 70f, piso - 580f, p)

        //Casa
        color = Color.rgb(255, 242, 21)
        p.color = color
        c.drawRect(370f, piso - 300f, 790f, piso, p)
        color = Color.rgb(0, 162, 232)
        p.color = color
        c.drawRect(650f, piso - 230f, 750f, piso - 130f, p)
        p.color = Color.BLACK
        c.drawRect(400f, piso - 230f, 540f, piso, p)

        color = Color.rgb(232, 117, 5)
        p.color = color
        c.drawRect(680f, piso - 500f, 770f, piso - 350f, p)
        val pa = Point(330, piso.toInt() - 300)
        val pb = Point(830, piso.toInt() - 300)
        val pc = Point(580, piso.toInt() - 550)

        val path = Path()
        path.setFillType(FillType.EVEN_ODD)
        path.moveTo(pb.x.toFloat(), pb.y.toFloat())
        path.lineTo(pb.x.toFloat(), pb.y.toFloat())
        path.lineTo(pc.x.toFloat(), pc.y.toFloat())
        path.lineTo(pa.x.toFloat(), pa.y.toFloat())
        path.close()
        c.drawPath(path, p)

        p.color = Color.LTGRAY
        c.drawOval(680f, piso - 580f, 770f, piso - 520f, p)
        c.drawOval(690f, piso - 660f, 800f, piso - 600f, p)
        c.drawOval(700f, piso - 740f, 840f, piso - 680f, p)

        p.color = Color.WHITE
        if (contador == 0){
            este.setTitle("Nevada ligera")
        }else if (contador == tiempo/2){
            Copos = Array<Copo>(Random.nextInt(150, 250), {Copo(25)})
            este.setTitle("Nevada intensa")
        }else if (contador == tiempo){
            Copos = Array<Copo>(Random.nextInt(30, 90), {Copo(15)})
            contador = 0;
            este.setTitle("Nevada ligera")
        }
        moverCopos(piso)
        for (copo in Copos) {
            c.drawCircle(copo.posX, copo.posY, copo.radio, p)
        }
        invalidate()
    }

    fun moverCopos(piso:Float) = GlobalScope.launch {
        for (copo in Copos) {
            copo.posY += copo.aumY
            if (copo.posY > piso + Random.nextInt(300, 1200)) copo.posY = 0f
        }
        contador++
        delay(1000L)
    }
}