package com.example.vaccinationc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Admindashboard extends AppCompatActivity {
    private Button Aback,Acampaign, Alogout;
    private FirebaseUser admindata;
    private DatabaseReference reference;
    private String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admindashboard);


        Aback =(Button)findViewById(R.id.buttonadminbackid);
        Acampaign = (Button)findViewById(R.id.buttonaddcampaignid);
        Alogout = (Button)findViewById(R.id.buttonadminlogoutid);

        Alogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(Admindashboard.this,MainActivity.class));
            }
        });

        Aback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Admindashboard.this,adminlogin.class));

            }
        });
        Acampaign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Admindashboard.this,Addcampaign.class));

            }
        });


        admindata = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("admindataa");
        userID = admindata.getUid();

        final TextView mfirstname = (TextView)findViewById(R.id.textViewadminfirstnameid);
        final TextView mlastname = (TextView)findViewById(R.id.textViewadminlastnameid);
        final TextView memail = (TextView)findViewById(R.id.textViewaadminemailid);
        final TextView mphone = (TextView)findViewById(R.id.textViewpphonenumberid);


        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull  DataSnapshot snapshot) {
                Admindata userdashbord = snapshot.getValue(Admindata.class);

                if(userdashbord != null){

                    String ffirstname = userdashbord.firstname;
                    String flastname = userdashbord.lastname;
                    String femail = userdashbord.email;
                    String fphone = userdashbord.phonenumber;


                    mfirstname.setText(ffirstname);
                    mlastname.setText(flastname);
                    memail.setText(femail);
                    mphone.setText(fphone);

                }

            }

            @Override
            public void onCancelled(@NonNull  DatabaseError error) {
                Toast.makeText(Admindashboard.this,"Something is Wrong!",Toast.LENGTH_LONG).show();

            }
        });
    }
}