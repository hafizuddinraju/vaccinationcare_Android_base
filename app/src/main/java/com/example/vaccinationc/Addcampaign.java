package com.example.vaccinationc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Addcampaign extends AppCompatActivity  {
    EditText Cvaccine, Cstartage, Cendage, Cdate, Cprice, Cplace;
    Button Csubmit, Cback, Clogout;

    DatabaseReference Addcampaigndata;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcampaign);


        Cback = (Button)findViewById(R.id.buttoncampaignbackid);
        Clogout = (Button)findViewById(R.id.buttoncampaignlogoutid);
        Csubmit = (Button)findViewById(R.id.buttonsubmitcampaignid);

        Cvaccine = (EditText) findViewById(R.id.editTextvaccineid);
        Cstartage = (EditText)findViewById(R.id.editTextstartageid);
        Cendage = (EditText)findViewById(R.id.editTextendageid);
        Cdate = (EditText)findViewById(R.id.editTextstartenddateid);
        Cprice = (EditText)findViewById(R.id.editTextvaccinepriceid);
        Cplace = (EditText)findViewById(R.id.editTextvaccineplaceid);



        Addcampaigndata = FirebaseDatabase.getInstance().getReference().child("campaign");

        Csubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mysubmit();
            }
        });


        Cback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Addcampaign.this,Admindashboard.class));
            }
        });

        Clogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(Addcampaign.this,MainActivity.class));
            }
        });


    }

    private void mysubmit() {


      String vaccine = Cvaccine.getText().toString().trim();
        String startage = Cstartage.getText().toString().trim();
        String endage = Cendage.getText().toString().trim();
        String date = Cdate.getText().toString().trim();
        String price = Cprice.getText().toString().trim();
        String place = Cplace.getText().toString().trim();


        campaign campaigns = new campaign(vaccine,startage,endage,date,price,place);
        Addcampaigndata.push().setValue(campaigns);

        Cvaccine.setText("");
        Cstartage.setText("");
        Cendage.setText("");
        Cdate.setText("");
        Cprice.setText("");
        Cplace.setText("");
        Toast.makeText(getApplicationContext(),"Value insert successfully!",Toast.LENGTH_LONG).show();


    }

   /* public void onClick(View view) {






        String vaccine = Cvaccine.getText().toString().trim();
        String startage = Cstartage.getText().toString().trim();
        String endage = Cendage.getText().toString().trim();
        String date = Cdate.getText().toString().trim();
        String price = Cprice.getText().toString().trim();
        String place = Cplace.getText().toString().trim();


        campaign objj = new campaign(startage,endage,date,price,place);
        FirebaseDatabase dbd = FirebaseDatabase.getInstance();
        DatabaseReference nodes = dbd.getReference("campaign");
        nodes.child(vaccine).setValue(objj);


        Toast.makeText(getApplicationContext(),"Value insert successfully!",Toast.LENGTH_LONG).show();

    }*/




}