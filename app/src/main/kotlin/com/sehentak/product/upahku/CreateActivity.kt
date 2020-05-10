package com.sehentak.product.upahku

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_create.*
import kotlinx.android.synthetic.main.app_toolbar.*
import java.text.NumberFormat
import java.util.*

class CreateActivity: AppCompatActivity(), View.OnClickListener {

    @Suppress("DEPRECATION")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)
        setSupportActionBar(app_toolbar)
        app_toolbar.title = getString(R.string.menu_create)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        create_btn_process.setOnClickListener(this)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.create_btn_process -> {
                val salary = create_edt_salary.toString().trim()

            }
        }
    }

    private fun TextInputEditText.textWatcher() {
        this.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(editable: Editable?) {

            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val locale: Locale = Locale.UK
                val currency = Currency.getInstance(locale)
                val cleanString = s?.toString()?.replace("[${currency.symbol},.]".toRegex(), "")
                val parsed = cleanString?.toDouble()
                val formatted = NumberFormat.getCurrencyInstance(locale).format(parsed ?: 0 / 100)

                this@textWatcher.setText(formatted)
                this@textWatcher.setSelection(formatted.length)
                this@textWatcher.addTextChangedListener(this)
            }
        })
    }
}