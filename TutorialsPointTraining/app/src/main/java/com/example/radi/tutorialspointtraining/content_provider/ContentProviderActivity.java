package com.example.radi.tutorialspointtraining.content_provider;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.radi.tutorialspointtraining.R;

public class ContentProviderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_provider);

        findViewById(R.id.btn_add_student).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAddName(v);
            }
        });

        findViewById(R.id.btn_get_students).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRetrieveStudents(v);
            }
        });
    }

    public void onAddName(View view) {
        // Add a new student record
        ContentValues values = new ContentValues();
        String studentName = ((EditText)findViewById(R.id.et_student_name)).getText().toString();
        String studentGrade = ((EditText)findViewById(R.id.et_student_grade)).getText().toString();

        values.put(StudentProvider.NAME, studentName);
        values.put(StudentProvider.GRADE, studentGrade);

        Uri uri = getContentResolver()
                .insert(StudentProvider.CONTENT_URI, values);
        Toast.makeText(getBaseContext(), uri.toString(), Toast.LENGTH_SHORT).show();
    }

    public void onRetrieveStudents(View view) {
        // Retrieve student records
        String URL = "content://com.example.radi.tutorialspointtraining.content_provider.StudentProvider";

        Uri students = Uri.parse(URL);
        Cursor c = managedQuery(students, null, null, null, "name");

        if (c.moveToFirst()) {
            do{
                Toast.makeText(this,
                        c.getString(c.getColumnIndex(StudentProvider._ID)) +
                                ", " +  c.getString(c.getColumnIndex( StudentProvider.NAME)) +
                                ", " + c.getString(c.getColumnIndex( StudentProvider.GRADE)),
                        Toast.LENGTH_SHORT).show();
            } while (c.moveToNext());
        }
    }
}
