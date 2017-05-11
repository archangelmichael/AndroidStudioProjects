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
        Cursor studentsCursor = getContentResolver().query(students, null, null, null, "_id");
        if (studentsCursor.moveToFirst()) {
            do {
                String studentID = studentsCursor.getString(studentsCursor.getColumnIndex(StudentProvider._ID));
                String studentName = studentsCursor.getString(studentsCursor.getColumnIndex( StudentProvider.NAME));
                String studentGrade = studentsCursor.getString(studentsCursor.getColumnIndex( StudentProvider.GRADE));
                Toast.makeText(
                        this,
                        String.format("%s %s %s", studentID, studentName, studentGrade),
                        Toast.LENGTH_SHORT)
                        .show();
            } while (studentsCursor.moveToNext());
        }

        studentsCursor.close();
    }
}
