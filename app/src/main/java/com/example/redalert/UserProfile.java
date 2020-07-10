package com.example.redalert;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

import static com.example.redalert.R.id.full_name;

public class UserProfile extends AppCompatActivity {
    TextView fullNameLabel, usernameLabel;
    TextInputLayout fullName, email, phoneNo, password;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);


        button = findViewById(R.id.back1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(UserProfile.this, Home.class);
                startActivity(intent1);

            }});


        //firebase to show data

        //hooks
        //fullName = findViewById(R.id.profile_name) ;
        //email = findViewById(R.id.profile_email);
       // phoneNo = findViewById(R.id.profile_phone);
        //password = findViewById(R.id.profile_password);
        fullNameLabel = findViewById(R.id.full_name);
        usernameLabel = findViewById(R.id.username);

        //showalldata
        showAllUserData();


        //end

    }


    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        moveTaskToBack(true);
                        UserProfile.super.onBackPressed();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

    private void showAllUserData() {
        Intent intent = getIntent();
        String user_name = intent.getStringExtra("name");
        String user_username = intent.getStringExtra("username");
        //String user_email = intent.getStringExtra("email");
       // String user_phoneNo = intent.getStringExtra("phoneNo");
       // String user_password = intent.getStringExtra("password");

        fullNameLabel.setText((user_name));
        usernameLabel.setText((user_username));
       // fullName.getEditText().setText(user_name);
        //email.getEditText().setText(user_email);
        //phoneNo.getEditText().setText(user_phoneNo);
       // password.getEditText().setText(user_password);
    }
}
