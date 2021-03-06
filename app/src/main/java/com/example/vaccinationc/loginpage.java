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

public class loginpage extends AppCompatActivity implements View.OnClickListener {

    private TextView register;
    private EditText memail,mpassword;
    private Button msignIn;
    private FirebaseAuth mAuth;
    private ProgressBar progressBar;
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);

        register = (TextView)findViewById(R.id.textViewregisterid);
        register.setOnClickListener(this);
        msignIn = (Button)findViewById(R.id.buttonsigninid);
        msignIn.setOnClickListener(this);
        memail = (EditText)findViewById(R.id.editTextEmailAddress);
        mpassword = (EditText)findViewById(R.id.editTextPassword);
        progressBar = (ProgressBar) findViewById(R.id.progressBarid);
        mAuth = FirebaseAuth.getInstance();
        back = (ImageView)findViewById(R.id.imageViewuserloginbackid);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(loginpage.this,Homepage.class));
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.textViewregisterid:
                startActivity(new Intent(this,Registerpage.class));
                break;
            case R.id.buttonsigninid:
                userLogin();
                break;
        }
    }

    private void userLogin() {
        String femail = memail.getText().toString().trim();
        String fpassword = mpassword.getText().toString().trim();

        if(femail.isEmpty()){
            memail.setError("Email is required!");
            memail.requestFocus();
            return;
        }
        if(fpassword.isEmpty()){
            mpassword.setError("Password is required!");
            mpassword.requestFocus();
            return;
        }
        if(fpassword.length()<6){
            mpassword.setError("password must be 6 characters!");
            mpassword.requestFocus();
            return;
        }
        progressBar.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(femail,fpassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull  Task<AuthResult> task) {
                if(task.isSuccessful()){

                    startActivity(new Intent(loginpage.this,Dashboard.class));

                } else {
                    Toast.makeText(loginpage.this,"Failed to Login! Try Again!",Toast.LENGTH_LONG).show();

                }

            }
        });
    }
}