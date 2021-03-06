package com.github.androiddevfr.form.rows

import android.content.Context
import android.support.v7.content.res.AppCompatResources
import android.util.Patterns
import com.github.androiddevfr.form.R
import com.github.androiddevfr.form.rows.enum.TextType

open class PhoneRow(context: Context) : TextRow(context) {

    init {
        validator = { v -> Patterns.PHONE.matcher(v).matches() }
        inputType = TextType.Phone
        icon = AppCompatResources.getDrawable(context, R.drawable.ic_phone_black_24dp)
    }

}