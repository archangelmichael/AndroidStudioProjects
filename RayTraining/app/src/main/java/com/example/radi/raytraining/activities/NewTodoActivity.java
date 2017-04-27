package com.example.radi.raytraining.activities;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import com.example.radi.raytraining.R;

import java.util.Calendar;
import java.util.Date;

public class NewTodoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_todo);
    }

    public void onAddNewTodo(View view) {
        String todoTitle = ((EditText) findViewById(R.id.etTodoTitle)).getText().toString();
        Date todoDate = getFullDateFrom(
                (DatePicker) findViewById(R.id.dpTodoDate),
                (TimePicker) findViewById(R.id.tpTodoDate));

        if (!todoTitle.isEmpty()) {
            Todo newTodo = new Todo(todoTitle, todoDate);
            Intent intent = new Intent();
            intent.putExtra("Todo", newTodo);
            setResult(RESULT_OK, intent);
        }
        else {
            setResult(RESULT_CANCELED);
        }

        finish();
    }

    private Date getFullDateFrom(DatePicker datePicker, TimePicker timePicker) {
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year =  datePicker.getYear();

        int hour;
        int minutes;
        if (Build.VERSION.SDK_INT > 23) {
            hour = timePicker.getHour();
            minutes = timePicker.getMinute();
        }
        else {
            hour = timePicker.getCurrentHour();
            minutes = timePicker.getCurrentMinute();
        }

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day, hour, minutes);
        return calendar.getTime();
    }
}
