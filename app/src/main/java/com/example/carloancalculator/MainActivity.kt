package com.example.carloancalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn = findViewById<View>(R.id.btnCalculate)
        btn.setOnClickListener(){
            val price:Double = txtPrice.text.toString().toDouble()
            val downPay:Double = txtPayment.text.toString().toDouble()
            val interestRate:Double = txtInterest.text.toString().toDouble()
            val loanP = txtLoanPeriod.text.toString().toInt()

            val carLoan = price - downPay
            val interest:Double = carLoan * interestRate/100 * loanP
            val monthlyRepayment:Double = (carLoan + interest) / loanP / 12

            txtResult.text = "RM"+"%.2f".format(monthlyRepayment)
            txtResultIntereset.text = "%.2f".format(interest)
            txtCarLoan.text = "RM"+"%.2f".format(carLoan)
        }
    }

}
