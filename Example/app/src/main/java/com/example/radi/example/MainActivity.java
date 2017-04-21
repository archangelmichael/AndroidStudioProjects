package com.example.radi.example;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.radi.example.animations.AnimationsActivity;
import com.example.radi.example.animations.SlidesActivity;
import com.example.radi.example.fragments.FragmentTabsActivity;
import com.example.radi.example.fragments.FragmentsActivity;
import com.example.radi.example.graphics.GraphicsActivity;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.app.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Make sure we're running on Honeycomb or higher to use ActionBar APIs
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            System.out.println("HONEYCOMB");
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

    public void onShowShare(View view) {
        Intent intent = new Intent(this, ShareActivity.class);
        startActivity(intent);
    }

    public void onShowMedia(View view) {
        Intent intent = new Intent(this, MediaActivity.class);
        startActivity(intent);
    }

    public void onShowGraphics(View view) {
        Intent intent = new Intent(this, GraphicsActivity.class);
        startActivity(intent);
    }

    public void onShowAnimations(View view) {
        Intent intent = new Intent(this, AnimationsActivity.class);
        startActivity(intent);
    }

    public void onShowSlides(View view) {
        Intent intent = new Intent(this, SlidesActivity.class);
        startActivity(intent);
    }

    // OPEN CONTACTS
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


    // REQUEST PERMISSIONS
    static final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 1;

    public void onCheckPermission(View view) {
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_CONTACTS);
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            System.out.println(" Permission denied! ");

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.WRITE_CONTACTS)) {
                System.out.println(" Request permission! ");
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            }
            else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(this,
                        new String[]{ Manifest.permission.WRITE_CONTACTS },
                        MY_PERMISSIONS_REQUEST_READ_CONTACTS);
            }
        }
        else {
            System.out.println(" Permission granted! ");
        }
    }

    @Override

    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[],
                                           int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_READ_CONTACTS: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    System.out.println(" Permission granted! ");
                }
                else {
                    System.out.println(" Permission denied! ");
                }

                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }
}
