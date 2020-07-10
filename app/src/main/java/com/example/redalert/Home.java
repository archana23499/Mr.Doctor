package com.example.redalert;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.textfield.TextInputLayout;

import static com.example.redalert.R.string.navigation_drawer_open;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    DrawerLayout drawerLayout;
    androidx.appcompat.widget.Toolbar toolbar;
    TextView textView;
    Menu menu;
     NavigationView navigationView;
     CardView physio, cardio, gyno, dentist, dermo, psych;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);




        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        textView=findViewById(R.id.textView);
        toolbar = findViewById(R.id.toolbar);
        //card
         cardio = (CardView) findViewById(R.id.cardio);
        physio = (CardView) findViewById(R.id.physio);
        gyno = (CardView) findViewById(R.id.gyno);
        dermo = (CardView) findViewById(R.id.dermo);
        dentist = (CardView) findViewById(R.id.dentist);
        psych = (CardView) findViewById(R.id.psych);
        //Add click listener to card

        cardio.setOnClickListener(this);
        physio.setOnClickListener(this);
        dermo.setOnClickListener(this);
        psych.setOnClickListener(this);
        gyno.setOnClickListener(this);
        dentist.setOnClickListener(this);

        setSupportActionBar(toolbar);

        //Hide or show  items
        Menu menu = navigationView.getMenu();
        menu.findItem(R.id.nav_logout).setVisible(false);
        menu.findItem(R.id.nav_profile).setVisible(false);



        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

        
    }


    @Override
    public void onBackPressed(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
       else
        {super.onBackPressed();
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_home:
                Intent intent = new Intent(Home.this, Home.class);
                startActivity(intent);
                break;
                case R.id.nav_profile:
                Intent intent1 = new Intent(Home.this, Physio.class);
                startActivity(intent1);
                break;
            case R.id.nav_login: menu.findItem(R.id.nav_logout).setVisible(true);
                menu.findItem(R.id.nav_profile).setVisible(true);
                menu.findItem(R.id.nav_logout).setVisible(false);
                break;
            case R.id.nav_logout: menu.findItem(R.id.nav_logout).setVisible(false);
                menu.findItem(R.id.nav_profile).setVisible(false);
                menu.findItem(R.id.nav_login).setVisible(true);
                break;
            case R.id.nav_share: Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(Home.this, UserProfile.class);
                startActivity(intent2);
            break;
        }
        drawerLayout.closeDrawer(GravityCompat.START); return true;
    }

    //card click

    @Override
    public void onClick(View v) {
        Intent i;
        switch(v.getId()) {
            case R.id.physio : i = new Intent(this,Physio.class); startActivity(i); break;
            case R.id.cardio : i = new Intent(this,Physio.class); startActivity(i); break;
            case R.id.psych : i = new Intent(this,Physio.class); startActivity(i); break;
            case R.id.dermo : i = new Intent(this,Physio.class); startActivity(i); break;
            case R.id.dentist : i = new Intent(this,Physio.class); startActivity(i); break;
            case R.id.gyno : i = new Intent(this,Physio.class); startActivity(i); break;


            default: break;

        }
    }




}

