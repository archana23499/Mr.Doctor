package com.example.redalert;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;


import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {
     Button button, signup, signup1;
    TextInputLayout username, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        signup = (Button) findViewById(R.id.btn);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Login.this, MainActivity.class);
                startActivity(intent1);

            }
        });


        username = findViewById(R.id.user_name);
        password = findViewById(R.id.password);

        button = findViewById((R.id.button2));


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(Login.this, Home.class);
                // startActivity(intent);
                if (!validatePassword() | !validateUsername()) {
                    return;
                } else {
                    isUser();
                }

                //get all the values
                // String username = username.getEditText().getText().toString();
                //String Password = password.getEditText().getText().toString();
            }

            //firebase
            private void isUser() {
                //progressBar.setVisibility(View.VISIBLE);
                final String userEnteredUsername = username.getEditText().getText().toString().trim();
                final String userEnteredPassword = password.getEditText().getText().toString().trim();
                DatabaseReference reference = FirebaseDatabase.getInstance().getReference("user");
                Query checkUser = reference.orderByChild("username").equalTo(userEnteredUsername);
                checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {
                            username.setError(null);
                            username.setErrorEnabled(false);
                            String passwordFromDB = dataSnapshot.child(userEnteredUsername).child("password").getValue(String.class);
                            if (passwordFromDB.equals(userEnteredPassword)) {
                                username.setError(null);
                                username.setErrorEnabled(false);
                                String nameFromDB = dataSnapshot.child(userEnteredUsername).child("name").getValue(String.class);
                                String usernameFromDB = dataSnapshot.child(userEnteredUsername).child("username").getValue(String.class);
                                String phoneNoFromDB = dataSnapshot.child(userEnteredUsername).child("phoneNo").getValue(String.class);
                                String emailFromDB = dataSnapshot.child(userEnteredUsername).child("email").getValue(String.class);
                                Intent intent = new Intent(getApplicationContext(), UserProfile.class);
                                intent.putExtra("name", nameFromDB);
                                intent.putExtra("username", usernameFromDB);
                                intent.putExtra("email", emailFromDB);
                                intent.putExtra("phoneNo", phoneNoFromDB);
                                intent.putExtra("password", passwordFromDB);
                                startActivity(intent);
                            } else {
                                // progressBar.setVisibility(View.GONE);
                                password.setError("Wrong Password");
                                password.requestFocus();
                            }
                        } else {
                            // progressBar.setVisibility(View.GONE);
                            username.setError("No such User exist");
                            username.requestFocus();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });


    }

    private Boolean validateUsername() {
        String val = username.getEditText().getText().toString();
        if (val.isEmpty()) {
            username.setError("Field cannot be empty");
            return false;
        } else {
            username.setError(null);
            username.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validatePassword() {
        String val = password.getEditText().getText().toString();


        if (val.isEmpty()) {
            password.setError("Field cannot be empty");
            return false;
        } else {
            password.setError(null);
            password.setErrorEnabled(false);
            return true;
        }
    }
}

