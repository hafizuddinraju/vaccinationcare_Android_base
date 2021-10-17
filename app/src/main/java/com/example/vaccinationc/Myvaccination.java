package com.example.vaccinationc;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class Myvaccination extends AppCompatActivity  {
     EditText vemail, vname, vstartdate, vdose, vprice, vplace;
    Button vupdate, vlogout, vback;
    DatePickerDialog.OnDateSetListener listener;
    int mdate, mmonth, myear;
     ImageView vcal;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myvaccination);
        vlogout = (Button) findViewById(R.id.buttonupdatelogoutid);
        vback = (Button) findViewById(R.id.buttonupdatebackid);
        vcal = (ImageView) findViewById(R.id.imageViewstartdateid);
        vstartdate = (EditText) findViewById(R.id.editTextvaccinestartid);

        vcal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cal = Calendar.getInstance();
                mdate = cal.get(Calendar.DATE);
                mmonth = cal.get(Calendar.MONTH);
                myear = cal.get(Calendar.YEAR);

                DatePickerDialog datePickerDialog = new DatePickerDialog(Myvaccination.this, android.R.style.Theme_DeviceDefault_Dialog, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        vstartdate.setText(dayOfMonth+"-"+month+"-"+year);
                    }
                }, myear,mmonth,mdate);
                datePickerDialog.show();
            }
        });


        vlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(Myvaccination.this,MainActivity.class));

            }
        });
        vback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Myvaccination.this,Dashboard.class));

            }
        });

    }

    public void onClick(View view) {


        vupdate = (Button) findViewById(R.id.buttonupdateid);
        vemail = (EditText) findViewById(R.id.editTextEmailAddressid);
        vname = (EditText) findViewById(R.id.editTextvaccinenameid);
        vstartdate = (EditText) findViewById(R.id.editTextvaccinestartid);
        vdose = (EditText) findViewById(R.id.editTextNumberofdoseid);
        vprice = (EditText) findViewById(R.id.editTextpriceid);
        vplace = (EditText) findViewById(R.id.editTextplaceid);

        

        String femail = vemail.getText().toString().trim();
        String name = vname.getText().toString().trim();
        String startdate = vstartdate.getText().toString().trim();
        String dose = vdose.getText().toString().trim();
        String price = vprice.getText().toString().trim();
        String place = vplace.getText().toString().trim();


        uservaccine obj = new uservaccine(name,startdate,dose,price,place);
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference node = db.getReference("uservaccine");
        node.child(femail).setValue(obj);

        vemail.setText("");
        vname.setText("");
        vstartdate.setText("");
        vdose.setText("");
        vprice.setText("");
        vplace.setText("");
        Toast.makeText(getApplicationContext(),"Value insert successfully!",Toast.LENGTH_LONG).show();

    }
}




     /*   vcal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cal = Calendar.getInstance();
                mdate = cal.get(Calendar.DATE);
                mmonth = cal.get(Calendar.MONTH);
                myear = cal.get(Calendar.YEAR);

                DatePickerDialog datePickerDialog = new DatePickerDialog(Myvaccination.this, android.R.style.Theme_DeviceDefault_Dialog, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        vstartdate.setText(dayOfMonth+"-"+month+"-"+year);
                    }
                }, myear,mmonth,mdate);
                datePickerDialog.show();
            }
        });


     /*

      /*  uservaccine obj = new uservaccine(name,startdate,dose,price,place);
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference node = db.getReference("uservaccine");
        node.child(femail).setValue(obj); */

    /*    vlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Myvaccination.this,MainActivity.class));
            }
        });
        vback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Myvaccination.this,Dashboard.class));
            }
        });


     /*   vemail.setText("");
        vname.setText("");
        vstartdate.setText("");
        vdose.setText("");
        vprice.setText("");
        vplace.setText("");
        Toast.makeText(getApplicationContext(),"Value insert successfully!",Toast.LENGTH_LONG).show();

       */




  /*  @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.textViewvaccine:
                startActivity(new Intent(this,Myvaccination.class));
                break;
            case R.id.buttonupdateid:
                mvaccine();
                break;


    }
}

    private void mvaccine() {
        String femail = vemail.getText().toString().trim();
        String name = vname.getText().toString().trim();
        String startdate = vstartdate.getText().toString().trim();
        String dose = vdose.getText().toString().trim();
        String price = vprice.getText().toString().trim();
        String place = vplace.getText().toString().trim();

        if(femail.isEmpty()){
            vemail.setError("Email is required!");
            vemail.requestFocus();
            return;
        }


        if(name.isEmpty()){
            vname.setError("Vaccine name is required!");
            vname.requestFocus();
            return;
        }
        if(dose.isEmpty()){
            vdose.setError("Dose is required!");
            vdose.requestFocus();
            return;
        }


        if(price.isEmpty()){
            vprice.setError("Price is required!");
            vprice.requestFocus();
            return;
        }
        if(place.isEmpty()){
            vplace.setError("place is required!");
        }
        uservaccine obj = new uservaccine(name,startdate,dose,price,place);
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference node = db.getReference("uservaccine");
        node.child(femail).setValue(obj);

        vemail.setText("");
        vname.setText("");
        vstartdate.setText("");
        vdose.setText("");
        vprice.setText("");
        vplace.setText("");
        Toast.makeText(getApplicationContext(),"Value insert successfully!",Toast.LENGTH_LONG).show();*/

