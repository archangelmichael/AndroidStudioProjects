package com.example.radi.example;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.app.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Make sure we're running on Honeycomb or higher to use ActionBar APIs
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {

        }
    }

    public void onSendMessage(View view) {
        Intent intent = new Intent(this, DetailedActivity.class);
        EditText editText = (EditText) findViewById(R.id.textInput);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void onShowFragments(View view) {
        Intent intent = new Intent(this, FragmentsActivity.class);
        startActivity(intent);
    }

    public void onShowTabs(View view) {
        Intent intent = new Intent(this, FragmentTabsActivity.class);
        startActivity(intent);
    }

    public void onShowSave(View view) {
        Intent intent = new Intent(this, SaveDataActivity.class);
        startActivity(intent);
    }

    public void onShowShareOptions(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        String title = getResources().getString(R.string.text_share_actions);
        Intent chooser = Intent.createChooser(intent, title);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(chooser);
        }
    }

    static final int PICK_CONTACT_REQUEST = 1;  // The request code

    public void onShowPickContact(View view) {
        Intent pickContactIntent = new Intent(Intent.ACTION_PICK, Uri.parse("content://contacts"));
        pickContactIntent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE); // Show user only contacts w/ phone numbers
        startActivityForResult(pickContactIntent, PICK_CONTACT_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        if (requestCode == PICK_CONTACT_REQUEST) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                System.out.println("Contact selected ");
            }
        }
    }

    public void onCheckPermission(View view) {
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_CALENDAR);
        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            System.out.println(" Permission granted! ");
        }
        else if (permissionCheck == PackageManager.PERMISSION_DENIED) {
            System.out.println(" Permission denied! ");
        }

    }
}
