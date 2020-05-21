package com.sehentak.product.upahku

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils.isEmpty
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
        create_btn_save.setOnClickListener(this)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.create_btn_process -> {
                create_tv_result.text = calculation().toString()
                create_btn_save.visibility = View.VISIBLE
                create_btn_process.visibility = View.GONE
            }

            R.id.create_btn_save -> finish()
        }
    }

    private fun calculation(): Int {
        val salaryPrice = create_edt_salary.text.toString().trim()
        val overTimeHour = create_edt_overtime_hour.text.toString().trim()
        val overTimePrice = create_edt_overtime_price.text.toString().trim()
        val transportHour = create_edt_transport_hour.text.toString().trim()
        val transportPrice = create_edt_transport_price.text.toString().trim()
        val allowancePrice = create_edt_allowance.text.toString().trim()

        val ovHour = if (!isEmpty(overTimeHour)) overTimeHour.toInt() else 0
        val ovPrice = if (!isEmpty(overTimePrice)) overTimePrice.toInt() else 0
        val overTime = ovHour * ovPrice

        val trHour = if (!isEmpty(transportHour)) transportHour.toInt() else 0
        val trPrice = if (!isEmpty(transportPrice)) transportPrice.toInt() else 0
        val transport = trHour * trPrice

        val salary = if (!isEmpty(salaryPrice)) salaryPrice.toInt() else 0
        val allowance = if (!isEmpty(allowancePrice)) allowancePrice.toInt() else 0

        return salary + overTime + transport + allowance
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