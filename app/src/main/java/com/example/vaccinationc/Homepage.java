package com.example.vaccinationc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Homepage extends AppCompatActivity {

    private Button madmin, muser,mhome, mcampaign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        madmin = (Button)findViewById(R.id.buttonadminid);
        muser = (Button)findViewById(R.id.buttonuserid);
        mhome = (Button)findViewById(R.id.buttonhomeid);
        mcampaign = (Button)findViewById(R.id.buttoncampaignid);

        mcampaign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Homepage.this,Showcampaign.class));

            }
        });


        madmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Homepage.this,Adminsignup.class));
            }
        });

        muser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Homepage.this,Registerpage.class));

            }
        });

        mhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Homepage.this,MainActivity.class));
            }
        });
    }
}