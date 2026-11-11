package com.elizierdias.handsign

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.LinearLayout

/**
 * First functional keyboard shell.
 * Letter keys currently commit text. Accurate Libras hand glyphs are a planned asset layer,
 * not approximated with unrelated Unicode hand emoji.
 */
class HandsignKeyboardView(
    context: Context
) : LinearLayout(context) {

    private val ime = context as HandsignImeService
    private val letters = "QWERTYUIOPASDFGHJKLÇZXCVBNM"

    init {
        orientation = VERTICAL
        setPadding(dp(5), dp(6), dp(5), dp(6))
        setBackgroundColor(Color.rgb(24, 26, 30))
        buildKeyboard()
    }

    private fun buildKeyboard() {
        addRow("QWERTYUIOP")
        addRow("ASDFGHJKLÇ")
        addRow("ZXCVBNM", includeControls = true)

        val bottom = LinearLayout(context).apply {
            orientation = HORIZONTAL
            gravity = Gravity.CENTER
        }
        bottom.addView(key("ABC", 0.8f) { /* alphabet layout reserved */ })
        bottom.addView(key("ESPAÇO", 3.2f) { ime.commit(" ") })
        bottom.addView(key("⌫", 1f) { ime.deleteOne() })
        bottom.addView(key("↵", 1f) { ime.enter() })
        addView(bottom, rowParams())
    }

    private fun addRow(text: String, includeControls: Boolean = false) {
        val row = LinearLayout(context).apply {
            orientation = HORIZONTAL
            gravity = Gravity.CENTER
        }
        text.forEach { ch ->
            row.addView(key(ch.toString(), 1f) { ime.commit(ch.toString()) })
        }
        addView(row, rowParams())
    }

    private fun key(label: String, weight: Float, action: () -> Unit): View {
        return Button(context).apply {
            text = label
            textSize = if (label.length > 1) 11f else 17f
            typeface = Typeface.DEFAULT_BOLD
            isAllCaps = false
            setTextColor(Color.WHITE)
            backgroundTintList = android.content.res.ColorStateList.valueOf(
                if (label == "ESPAÇO") Color.rgb(67, 73, 84) else Color.rgb(48, 52, 60)
            )
            minHeight = dp(45)
            minimumHeight = dp(45)
            setPadding(dp(1), 0, dp(1), 0)
            setOnClickListener { action() }
            layoutParams = LayoutParams(0, dp(48), weight).apply {
                setMargins(dp(2), dp(2), dp(2), dp(2))
            }
        }
    }

    private fun rowParams() = LayoutParams(
        LayoutParams.MATCH_PARENT,
        LayoutParams.WRAP_CONTENT
    )

    private fun dp(value: Int) = (value * resources.displayMetrics.density).toInt()
}
