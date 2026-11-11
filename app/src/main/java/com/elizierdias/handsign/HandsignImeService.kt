package com.elizierdias.handsign

import android.inputmethodservice.InputMethodService
import android.view.View

class HandsignImeService : InputMethodService() {
    override fun onCreateInputView(): View = HandsignKeyboardView(this)

    fun commit(value: String) {
        currentInputConnection?.commitText(value, 1)
    }

    fun deleteOne() {
        currentInputConnection?.deleteSurroundingText(1, 0)
    }

    fun enter() {
        val connection = currentInputConnection ?: return
        val handled = connection.performEditorAction(currentInputEditorInfo?.imeOptions
            ?.and(android.view.inputmethod.EditorInfo.IME_MASK_ACTION) ?: 0)
        if (!handled) commit("\n")
    }
}
