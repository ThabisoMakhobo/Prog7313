package com.example.smartspend

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Calendar

class EntryFormActivity : AppCompatActivity() {
    private val expenseCategories = mutableListOf(
        "Transport", "Subscriptions", "Groceries", "Rent & Utilities",
        "Debt & Loans", "Health & Wellness", "Entertainment",
        "Food & Dining", "Education", "Personal Care", "Shopping"
    )

    private val incomeCategories = mutableListOf(
        "Savings & Investments", "Primary Income", "Side Hustles/Extra Income",
        "Passive Income", "Student-Related Income", "Refunds or Reimbursements", "Other/Unexpected"
    )

    private lateinit var recurringExpenseInput: AutoCompleteTextView

    private val recurringOptions = listOf(
        "Once-off", "Daily", "Weekly", "Monthly", "Yearly"
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.income_entry_form)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_income)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val amounts = listOf("10", "20", "50", "100", "200", "500", "1000")
        val adapter_amounts =
            ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, amounts)
        val amountInput = findViewById<AutoCompleteTextView>(R.id.amountInput)
        amountInput.setAdapter(adapter_amounts)

        val dateInput: AutoCompleteTextView = findViewById(R.id.dateInput)
        val calendar = Calendar.getInstance()

        dateInput.setOnClickListener {
            val day = calendar.get(Calendar.DAY_OF_MONTH)
            val month = calendar.get(Calendar.MONTH)

            val datePicker = DatePickerDialog(
                this,
                { _, _, selectedMonth, selectedDay ->
                    val displayDate = String.format("%02d/%02d", selectedDay, selectedMonth + 1)
                    dateInput.setText(displayDate)
                },
                calendar.get(Calendar.YEAR), month, day
            )

            datePicker.datePicker.calendarViewShown = false
            datePicker.show()
        }

        val inflater = layoutInflater

        val expenseView = inflater.inflate(R.layout.expense_entry_form, null)
        val incomeView = inflater.inflate(R.layout.income_entry_form, null)

        val expenseCategoryInput = expenseView.findViewById<AutoCompleteTextView>(R.id.expenseCategoryInput)
        val incomeCategoryInput = incomeView.findViewById<AutoCompleteTextView>(R.id.incomeCategoryInput)

        val expenseAdapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, expenseCategories)
        val incomeAdapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, incomeCategories)

        expenseCategoryInput.setAdapter(expenseAdapter)
        incomeCategoryInput.setAdapter(incomeAdapter)

        expenseCategoryInput.setOnItemClickListener { _, _, position, _ ->
            val selected = expenseAdapter.getItem(position)
        }

        incomeCategoryInput.setOnItemClickListener { _, _, position, _ ->
            val selected = incomeAdapter.getItem(position)
        }

        // Dynamically add new expense category if not found
        expenseCategoryInput.setOnDismissListener {
            val input = expenseCategoryInput.text.toString().trim()
            if (input.isNotEmpty() && !expenseCategories.contains(input)) {
                expenseCategories.add(input)
                expenseAdapter.notifyDataSetChanged()
            }
        }

        // Dynamically add new income category if not found
        incomeCategoryInput.setOnDismissListener {
            val input = incomeCategoryInput.text.toString().trim()
            if (input.isNotEmpty() && !incomeCategories.contains(input)) {
                incomeCategories.add(input)
                incomeAdapter.notifyDataSetChanged()
            }
        }

        recurringExpenseInput = findViewById(R.id.recurringExpenseInput)

        val recurringAdapter =
            ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, recurringOptions)
        recurringExpenseInput.setAdapter(recurringAdapter)

    }

    fun add_income(view: View) {}
    fun save_income(view: View) {}
    fun add_expense(view: View) {}
    fun save_expense(view: View) {}
    fun goto_graph(view: View) {}
    fun goto_lst(view: View) {}
    fun goto_rewards(view: View) {}
}
