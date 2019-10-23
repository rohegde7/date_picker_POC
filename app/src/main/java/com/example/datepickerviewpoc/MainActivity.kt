package com.example.datepickerviewpoc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.savvi.rangedatepicker.CalendarPickerView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button.setOnClickListener {
            showCalendar()
        }
    }

    fun showCalendar() {
        val calendarPickerView = CalendarPickerView(this, null)

        calendarPickerView.setDateSelectableFilter {
            if (true) true  // TOdo --> set this to false/true and see the difference
            else true
        }

        val calstart = Calendar.getInstance()
        calstart.set(Calendar.DAY_OF_MONTH, 1)
        calstart.add(Calendar.MONTH, -1)

        val calend = Calendar.getInstance()
        calend.add(Calendar.MONTH, -1)
        calend.set(Calendar.DAY_OF_MONTH, calend.getActualMaximum(Calendar.DAY_OF_MONTH))
        calend.add(Calendar.DATE, 1)

        calendarPickerView.init(calstart.getTime(), calend.getTime())
            .inMode(CalendarPickerView.SelectionMode.RANGE)


        root.addView(calendarPickerView)
    }
}
