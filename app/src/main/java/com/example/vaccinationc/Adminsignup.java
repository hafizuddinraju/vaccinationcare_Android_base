package com.example.vaccinationc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Adminsignup extends AppCompatActivity implements View.OnClickListener {

    private EditText mfirstname,mlastname,memail,mphonenumber,mpassword;

    private Button msignup;
    private TextView mlogin;
    private ProgressBar mprogressBars;
    private ImageView backbutton;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminsignup);

        mAuth = FirebaseAuth.getInstance();
        mfirstname = (EditText)findViewById(R.id.editTextfirstnameid);
        mlastname = (EditText)findViewById(R.id.editTextlastnameid);
        memail = (EditText)findViewById(R.id.editTextemailid);
        mphonenumber = (EditText)findViewById(R.id.editTextphonenumberid);
        mpassword = (EditText)findViewById(R.id.editTextpasswordid);
        msignup = (Button)findViewById(R.id.buttonadminsignupid);
        msignup.setOnClickListener(this);
        mlogin =(TextView)findViewById(R.id.textViewallreadyregisterid);
        mlogin.setOnClickListener(this);
        mprogressBars = (ProgressBar)findViewById(R.id.progressBaradminsignid);
        backbutton = (ImageView)findViewById(R.id.imageViewsignupbackid);

        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Adminsignup.this,Homepage.class));
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.textViewadminsignupid:
                startActivity(new Intent(this,Adminsignup.class));
                break;

            case R.id.buttonadminsignupid:
                mregister();
                break;
            case R.id.textViewallreadyregisterid:
                startActivity(new Intent(this,adminlogin.class));
                break;
        }


    }

    private void mregister() {
        String firstname = mfirstname.getText().toString().trim();
        String lastname = mlastname.getText().toString().trim();
        String email = memail.getText().toString().trim();
        String phonenumber = mphonenumber.getText().toString().trim();
        String password = mpassword.getText().toString().trim();





        if(firstname.isEmpty()){
            mfirstname.setError("User name is required!");
            mfirstname.requestFocus();
            return;
        }
        if(lastname.isEmpty()){
            mlastname.setError("User name is required!");
            mlastname.requestFocus();
            return;
        }

        if(email.isEmpty()){
            memail.setError("Email is required!");
            memail.requestFocus();
            return;
        }
        if(phonenumber.isEmpty()){
            mphonenumber.setError("Phone number id required!");
            mphonenumber.requestFocus();
            return;
        }
        if(password.isEmpty()){
            mpassword.setError("password is required!");
            mpassword.requestFocus();
            return;
        }
        if(password.length()<6){
            mpassword.setError("password must be 6 charaters!");
            mpassword.requestFocus();
            return;
        }
        mprogressBars.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){

                            Admindata admindata = new Admindata(firstname,lastname,email,phonenumber);

                            FirebaseDatabase.getInstance().getReference("admindataa")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(admindata).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull  Task<Void> task) {
                                    if(task.isSuccessful()){
                                        Toast.makeText(Adminsignup.this,"User has been registered successfully!",Toast.LENGTH_LONG).show();
                                        mprogressBars.setVisibility(View.VISIBLE);
                                        startActivity(new Intent(Adminsignup.this,adminlogin.class));
                                    }else {
                                        Toast.makeText(Adminsignup.this,"Failed to register! Try Again!",Toast.LENGTH_LONG).show();
                                        mprogressBars.setVisibility(View.VISIBLE);

                                    }

                                }
                            });

                        }else {
                            Toast.makeText(Adminsignup.this,"Failed to register! Try Again!",Toast.LENGTH_LONG).show();
                            mprogressBars.setVisibility(View.VISIBLE);

                        }

                    }
                });
    }
}