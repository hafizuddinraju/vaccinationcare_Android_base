package com.example.vaccinationc;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class VaccineU extends AppCompatActivity {
    EditText mroll,mname,mpoint,mgoal,mlast;
    DatePickerDialog.OnDateSetListener listener;
    int mdate,mmonth,myear;
    ImageView mcal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccine_u);
        mcal = (ImageView)findViewById(R.id.imageViewcalid);
        mpoint =(EditText) findViewById(R.id.editTextP3id);
        mcal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cal = Calendar.getInstance();
                mdate = cal.get(Calendar.DATE);
                mmonth = cal.get(Calendar.MONTH);
                myear = cal.get(Calendar.YEAR);

                DatePickerDialog datePickerDialog = new DatePickerDialog(VaccineU.this, android.R.style.Theme_DeviceDefault_Dialog, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        mpoint.setText(dayOfMonth+"-"+month+"-"+year);
                    }
                }, myear,mmonth,mdate);
                datePickerDialog.show();
            }
        });


    }




    public void process(View view){
        mroll = (EditText)findViewById(R.id.editTextP1id);
        mname = (EditText)findViewById(R.id.editTextP2id);
        mpoint =(EditText) findViewById(R.id.editTextP3id);
        mgoal = (EditText)findViewById(R.id.editTextP4id);
        mlast = (EditText)findViewById(R.id.editTextP5id);



        String roll = mroll.getText().toString().trim();
        String name = mname.getText().toString().trim();
        String course = mpoint.getText().toString().trim();
        String duration = mgoal.getText().toString().trim();
        String last = mlast.getText().toString().trim();

        dataholder obj = new dataholder(name,course,duration,last);
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference node = db.getReference("vaccine");
        node.child(roll).setValue(obj);

        mroll.setText("");
        mname.setText("");
        mpoint.setText("");
        mgoal.setText("");
        mlast.setText("");
        Toast.makeText(getApplicationContext(),"value add!",Toast.LENGTH_LONG).show();
    }
}