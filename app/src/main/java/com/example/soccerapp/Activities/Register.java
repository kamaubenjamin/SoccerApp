package com.example.soccerapp.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.soccerapp.Db.DatabaseHelper;
import com.example.soccerapp.Methods.UserModel;
import com.example.soccerapp.R;

public class Register extends Activity {
    TextView createTexts;
    EditText fullName,Email,password,phone;
    Button registerBtn;

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate( savedInstanceState );
        setContentView( R.layout.activity_register );

        //DECLARE VARIABLES


        fullName = findViewById(R.id.fullName);
        phone = findViewById( R.id.phone );
        Email = findViewById(R.id.Email);
        password = findViewById(R.id.password);
        registerBtn = findViewById(R.id.registerBtn);
        createTexts =findViewById( R.id.createText );



      Button registerBtn = (Button)findViewById( R.id.registerBtn );
      registerBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //add/store text to string
                String stringName = fullName.getText().toString();
                String stringEmail = Email.getText().toString();
                String stringPass = password.getText().toString();
                String stringPhone = phone.getText().toString();


                if (stringName.length() <=0 || stringEmail.length() <=0 || stringPass.length() <=0 || stringPhone.length() <=0){
                    Toast.makeText(Register.this, "Enter All Data", Toast.LENGTH_SHORT).show();
                }else {
                    DatabaseHelper databaseHelper = new DatabaseHelper(Register.this);
                    UserModel studentsModel = new UserModel(stringName,stringEmail,stringPass,stringPhone);
                    databaseHelper.addUSER(studentsModel);
                    Toast.makeText(Register.this, "Registered Student Successfully", Toast.LENGTH_SHORT).show();
                    finish();
                    Intent intent = new Intent(Register.this,MainActivity.class);
                    Register.this.startActivity((intent));
                }

            }
        } );

      TextView createTexts = (TextView) findViewById( R.id.createText );
      createTexts.setOnClickListener( new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent =new Intent(Register.this,MainActivity.class);
              startActivity( intent );
          }
      } );


    }
}
