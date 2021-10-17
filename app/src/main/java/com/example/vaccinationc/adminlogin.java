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

public class adminlogin extends AppCompatActivity implements View.OnClickListener{

    private EditText Aemail,Apassword;
    private Button Alogin;
    private TextView Asignup;
    private ProgressBar AprogressBar;
    private FirebaseAuth mAuth;
    private ImageView backbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlogin);

        Aemail = (EditText)findViewById(R.id.editTextemailaddressid);
        Apassword = (EditText)findViewById(R.id.editTextloginpasswordid);
        Alogin = (Button)findViewById(R.id.buttonloginid);
        Alogin.setOnClickListener(this);
        Asignup = (TextView)findViewById(R.id.textViewadminsigpupid);
        Asignup.setOnClickListener(this);
        AprogressBar = (ProgressBar)findViewById(R.id.progressBarlonginid);
        mAuth = FirebaseAuth.getInstance();
        backbutton = (ImageView)findViewById(R.id.imageViewloginbackid);

        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(adminlogin.this,Homepage.class));
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.textViewadminsigpupid:
                startActivity(new Intent(this,Adminsignup.class));
                break;
            case R.id.buttonloginid:
                userLogin();
                break;
        }

    }

    private void userLogin() {

        String email = Aemail.getText().toString().trim();
        String password = Apassword.getText().toString().trim();

        if(email.isEmpty()){
            Aemail.setError("Email is required!");
            Aemail.requestFocus();
            return;
        }
        if(password.isEmpty()){
            Apassword.setError("Password is required!");
            Apassword.requestFocus();
            return;
        }
        if(password.length()<6){
            Apassword.setError("password must be 6 characters!");
            Apassword.requestFocus();
            return;
        }
        AprogressBar.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){

                    startActivity(new Intent(adminlogin.this,Admindashboard.class));

                } else {
                    Toast.makeText(adminlogin.this,"Failed to Login! Try Again!",Toast.LENGTH_LONG).show();

                }

            }
        });
    }
}