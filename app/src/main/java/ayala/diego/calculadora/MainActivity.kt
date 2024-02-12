package ayala.diego.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var oper: Int = 0
    var numero1: Double = 0.0
    lateinit var tv_num1: TextView
    lateinit var tv_num2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv_num1 = findViewById(R.id.tv_num1)
        tv_num2 = findViewById(R.id.tv_num2)
        val btnC: Button = findViewById(R.id.btnC)
        val btnBorrar: Button = findViewById(R.id.btnBorrar)
        val btnIgual: Button = findViewById(R.id.btnIgual)

        btnIgual.setOnClickListener{
            var numero2: Double = tv_num2.text.toString().toDouble()
            var resp: Double = 0.0

            when(oper){
                1 -> resp = numero1 + numero2
                2 -> resp = numero1 - numero2
                3 -> resp = numero1 * numero2
                4 -> resp = numero1 / numero2
            }

            if(!tv_num1.text.toString().contains("="))
                tv_num1.setText(tv_num1.text.toString() + tv_num2.text.toString() + " =")

            var respString: String = resp.toString();

            if(respString.endsWith(".0"))
                respString = respString.substring(0, respString.length - 2);

            tv_num2.setText(respString)
        }

        btnC.setOnClickListener{
            tv_num1.setText("")
            tv_num2.setText("")
            numero1 = 0.0
            oper = 0
        }

        btnBorrar.setOnClickListener {
            val num2 = tv_num2.text.toString()
            if (num2.length > 1 && !num2.equals("NaN")) {
                tv_num2.text = num2.substring(0, num2.length - 1)
            } else
                tv_num2.text = ""
        }
    }

    fun presionarDigito(view: View){
        var num1: String = tv_num1.text.toString()
        var num2: String = tv_num2.text.toString()

        if(num1.contains("=")) {
            tv_num1.setText("")
            num2 = ""
        }

        if(num2.equals("NaN"))
            num2 = ""

        when(view.id){
            R.id.btn0 -> tv_num2.setText(num2 + "0")
            R.id.btn1 -> tv_num2.setText(num2 + "1")
            R.id.btn2 -> tv_num2.setText(num2 + "2")
            R.id.btn3 -> tv_num2.setText(num2 + "3")
            R.id.btn4 -> tv_num2.setText(num2 + "4")
            R.id.btn5 -> tv_num2.setText(num2 + "5")
            R.id.btn6 -> tv_num2.setText(num2 + "6")
            R.id.btn7 -> tv_num2.setText(num2 + "7")
            R.id.btn8 -> tv_num2.setText(num2 + "8")
            R.id.btn9 -> tv_num2.setText(num2 + "9")
            R.id.btnPunto -> {
                if(!tv_num2.text.toString().contains("."))
                    tv_num2.setText(num2 + ".")
            }
        }
    }

    fun clickOperacion(view: View){
        var num2: String = tv_num2.text.toString()

        if(!num2.equals("NaN")) {
            numero1 = num2.toDouble()
            when (view.id) {
                R.id.btnSuma -> {
                    tv_num1.setText(num2 + "+")
                    oper = 1
                }

                R.id.btnResta -> {
                    tv_num1.setText(num2 + "-")
                    oper = 2
                }

                R.id.btnMult -> {
                    tv_num1.setText(num2 + "*")
                    oper = 3
                }

                R.id.btnDiv -> {
                    tv_num1.setText(num2 + "/")
                    oper = 4
                }
            }
        }
        tv_num2.setText("")
    }
}