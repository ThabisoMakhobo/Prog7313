package com.example.smartspend

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity_dashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_dashboard)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_income)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //Declaration
        val mainAccount = findViewById<EditText>(R.id.main_acc_amt)
        val savingsAccount = findViewById<EditText>(R.id.sav_acc_amt)
        var summaryAmt = findViewById<TextView>(R.id.total_amount)
        val editMainBtn = findViewById<Button>(R.id.editMainAccount)
        val editSavingsBtn = findViewById<Button>(R.id.editSavingsAccount)
        val backBtn = findViewById<ImageView>(R.id.LogoutBtn)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_income)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun sum(mainAccount: Double, savingsAccount: Double): Double {
        return mainAccount + savingsAccount }


    fun goto_entry(view: View) {
        startActivity(Intent(this, EntryFormActivity::class.java))
    }
    fun goto_graph(view: View) {}
    fun goto_lst(view: View) {
        startActivity(Intent(this, TransLstNdFilteringActivity::class.java))
    }
    fun edit_mainAcc(view: View) {
        val mainAccount = findViewById<EditText>(R.id.main_acc_amt)
        val savingsAccount = findViewById<EditText>(R.id.sav_acc_amt)
        var summaryAmt = findViewById<TextView>(R.id.total_amount)

        val mainAcctText = mainAccount.text.toString().trim()
        val savingAcctText = savingsAccount.text.toString().trim()

        if (mainAcctText.isNotEmpty() && savingAcctText.isNotEmpty()) {
            val mainAcct = mainAcctText.toDoubleOrNull() ?: 0.0
            val savingAcct = savingAcctText.toDoubleOrNull() ?: 0.0
            val total = sum(mainAcct, savingAcct)

            summaryAmt.text = total.toString()
        } else {
            summaryAmt.text = "0.0"
        }
    }

    fun edit_savAcc(view: View) {
        val mainAccount = findViewById<EditText>(R.id.main_acc_amt)
        val savingsAccount = findViewById<EditText>(R.id.sav_acc_amt)
        var summaryAmt = findViewById<TextView>(R.id.total_amount)

        val mainAcctText = mainAccount.text.toString().trim()
        val savingAcctText = savingsAccount.text.toString().trim()

        if (mainAcctText.isNotEmpty() && savingAcctText.isNotEmpty()) {
            val mainAcct = mainAcctText.toDoubleOrNull() ?: 0.0
            val savingAcct = savingAcctText.toDoubleOrNull() ?: 0.0
            val total = sum(mainAcct, savingAcct)

            summaryAmt.text = total.toString()
        } else {
            summaryAmt.text = "0.0"
        }
    }

    fun go_back(view: View) {
        startActivity(Intent(this, MainActivity::class.java))
    }

    fun goto_rewards(view: View) {}
}