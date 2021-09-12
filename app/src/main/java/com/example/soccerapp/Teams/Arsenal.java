package com.example.soccerapp.Teams;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.soccerapp.Db.DatabaseHelper;
import com.example.soccerapp.Methods.TeamsModel;
import com.example.soccerapp.R;
import com.example.soccerapp.TeamsDetails.ArsenalPlayerDetails;

public class Arsenal extends Activity {
    Button button_add,button_view;
    EditText edittext_name,edittext_position,edittext_age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_arsenal );

        //initialize variables

        edittext_name =findViewById(R.id.edittext_name );
        edittext_position= findViewById( R.id.edittext_position );
        edittext_age = findViewById( R.id.edittext_age );
        button_add=findViewById( R.id.button_add );
        button_view = findViewById( R.id.button_view );

        //call button onclick Register
        button_add.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name= edittext_name.getText().toString();
                String position = edittext_position.getText().toString();
                String age= edittext_age.getText().toString();

                if (name.length() <=0 ||  position.length() <=0 || age.length() <=0){
                    Toast.makeText(Arsenal.this, "Enter All Data", Toast.LENGTH_SHORT).show();
                }
                else {
                    DatabaseHelper db = new DatabaseHelper( Arsenal.this);
                    TeamsModel teamsModel = new TeamsModel( name,position,age );
                    db.addARSENAL( teamsModel );
                    Toast.makeText( Arsenal.this,"Added SuccessFully",Toast.LENGTH_SHORT ).show();
                    finish();
                     Intent intent = new Intent(Arsenal.this,Arsenal.class);
                    startActivity((intent));

                }

            }
        } );
        button_view.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Arsenal.this, ArsenalPlayerDetails.class);
                startActivity( intent );

            }
        } );



    }
}