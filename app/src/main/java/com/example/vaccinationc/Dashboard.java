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

public class Dashboard extends AppCompatActivity {
    private Button mlogout,myvaccine;
    private FirebaseUser user;
    private DatabaseReference reference;
    private String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        mlogout =(Button)findViewById(R.id.buttonlogoutid);
        myvaccine = (Button)findViewById(R.id.buttonaddvaccineid);


        myvaccine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                startActivity(new Intent(Dashboard.this,Myvaccination.class));

            }
        });



        mlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(Dashboard.this,MainActivity.class));
            }
        });
        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("users");
        userID = user.getUid();

        final TextView memail = (TextView)findViewById(R.id.textViewsetemailid);
        final TextView mname = (TextView)findViewById(R.id.textViewsetnameid);
        final TextView mdob = (TextView)findViewById(R.id.textViewsetdobid);
        final TextView mphone = (TextView)findViewById(R.id.textViewsetphoneid);


        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull  DataSnapshot snapshot) {
                User userdashbord = snapshot.getValue(User.class);

                if(userdashbord != null){
                    String femail = userdashbord.email;
                    String fname = userdashbord.name;
                    String fdateofborth = userdashbord.dateofbirth;
                    String fphone = userdashbord.phonenumber;


                    memail.setText(femail);
                    mname.setText(fname);
                    mdob.setText(fdateofborth);
                    mphone.setText(fphone);

                }

            }

            @Override
            public void onCancelled(@NonNull  DatabaseError error) {
                Toast.makeText(Dashboard.this,"Something is Wrong!",Toast.LENGTH_LONG).show();

            }
        });
    }
}