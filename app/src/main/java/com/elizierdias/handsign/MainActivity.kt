package com.elizierdias.handsign

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.Gravity
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val pad = (20 * resources.displayMetrics.density).toInt()
        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            setPadding(pad, pad, pad, pad)
            setBackgroundColor(0xFF101114.toInt())
        }

        val title = TextView(this).apply {
            text = "HANDSIGN"
            textSize = 32f
            setTextColor(0xFFFFFFFF.toInt())
            gravity = Gravity.CENTER
        }
        val subtitle = TextView(this).apply {
            text = "Teclado visual baseado no alfabeto manual de Libras"
            textSize = 16f
            setTextColor(0xFFB8BEC9.toInt())
            gravity = Gravity.CENTER
            setPadding(0, pad / 2, 0, pad)
        }
        val note = TextView(this).apply {
            text = "Versão inicial: teclado de texto funcional. As ilustrações anatómicas das mãos serão adicionadas na próxima etapa."
            textSize = 14f
            setTextColor(0xFFB8BEC9.toInt())
            gravity = Gravity.CENTER
            setPadding(0, 0, 0, pad)
        }
        val enable = Button(this).apply {
            text = "1. Ativar teclado HANDSIGN"
            setOnClickListener {
                startActivity(Intent(Settings.ACTION_INPUT_METHOD_SETTINGS))
            }
        }
        val choose = Button(this).apply {
            text = "2. Selecionar HANDSIGN"
            setOnClickListener {
                val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.showInputMethodPicker()
            }
        }
        val test = Button(this).apply {
            text = "Testar num campo de texto"
            setOnClickListener {
                val field = android.widget.EditText(this@MainActivity).apply {
                    hint = "Escreve aqui para testar"
                    textSize = 18f
                }
                root.addView(field, 2)
                field.requestFocus()
                val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.showSoftInput(field, InputMethodManager.SHOW_IMPLICIT)
            }
        }

        root.addView(title)
        root.addView(subtitle)
        root.addView(note)
        root.addView(enable)
        root.addView(choose)
        root.addView(test)
        setContentView(root)
    }
}
