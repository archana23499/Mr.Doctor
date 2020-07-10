package com.example.redalert;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

public class Appointment extends AppCompatActivity {
    Button end;

    TextInputLayout regName, regTime,
            regEmail, regPhone, regDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);


        //Hooks to all xml elements in activity_sign_up.xml
        regName = findViewById(R.id.name);
        regTime = findViewById(R.id.time);
        regEmail = findViewById(R.id.email);
        regPhone = findViewById(R.id.phone);
        regDate = findViewById(R.id.date);


        end = findViewById(R.id.end);
        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent1 = new Intent(Appointment.this, end.class);
                //startActivity(intent1);


                if(!validateName() | !validatePassword() | !validatePhoneNo() | !validateEmail() | !validateUsername()){
                   // return ;
                    Intent intent1 = new Intent(Appointment.this, end.class);
                    startActivity(intent1);
                }

            }});

    }


    private Boolean validateName() {
        String val =regName.getEditText().getText().toString();
        if(val.isEmpty()) {
            regName.setError("Field cannot be empty");
            return false;
        }
        else
        {
            regName.setError(null);
            return  true;
        }
    }

    private Boolean validateUsername() {
        String val = regTime.getEditText().getText().toString();
        String noWhiteSpace = "\\A\\w{4,20}\\z";

        if (val.isEmpty()) {
            regTime.setError("Field cannot be empty");
            return false;
        } else if (val.length() >= 15) {
            regTime.setError("Username too long");
            return false;
        } else if (!val.matches(noWhiteSpace)) {
            regTime.setError("White Spaces are not allowed");
            return false;
        } else {
            regTime.setError(null);
            regTime.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validateEmail() {
        String val = regEmail.getEditText().getText().toString();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (val.isEmpty()) {
            regEmail.setError("Field cannot be empty");
            return false;
        } else if (!val.matches(emailPattern)) {
            regEmail.setError("Invalid email address");
            return false;
        } else {
            regEmail.setError(null);
            regEmail.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validatePhoneNo() {
        String val = regPhone.getEditText().getText().toString();

        if (val.isEmpty()) {
            regPhone.setError("Field cannot be empty");
            return false;
        } else {
            regPhone.setError(null);
            regPhone.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validatePassword() {
        String val = regDate.getEditText().getText().toString();
        String passwordVal =
                "(?=.*[0-9])" +         //at least 1 digit
                        "(?=.*[a-z])" +         //at least 1 lower case letter
                        "(?=.*[A-Z])" +         //at least 1 upper case letter
                        //"(?=.*[a-zA-Z])" +      //any letter
                        // "(?=.*[@#$%^&+=])" +    //at least 1 special character
                        // "(?=\\S+$)" +           //no white spaces
                        ".{4,}" ;              //at least 4 characters


        if (val.isEmpty()) {
            regDate.setError("Field cannot be empty");
            return false;
        } else if (!val.matches(passwordVal)) {
            regDate.setError("Password is too weak");
            return false;
        } else {
            regDate.setError(null);
            regDate.setErrorEnabled(false);
            return true;
        }
    }
}
