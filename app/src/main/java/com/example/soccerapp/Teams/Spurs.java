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
import com.example.soccerapp.TeamsDetails.SpursPlayerDetails;

public class Spurs extends Activity {
    EditText edittext_name,edittext_position,edittext_age;
    Button button_add,button_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_spurs );

        edittext_name= (EditText) findViewById( R.id.edittext_name );
        edittext_position=(EditText) findViewById( R.id.edittext_position );
        edittext_age=(EditText) findViewById( R.id.edittext_age );
        button_add=(Button)findViewById( R.id.button_add );
        button_view=(Button) findViewById( R.id.button_view );
        button_add.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edittext_name.getText().toString();
                String position = edittext_position.getText().toString();
                String age = edittext_age.getText().toString();

                if ( name.length()<=0 || position.length()<=0||age.length()<=0) {
                    Toast.makeText( Spurs.this, "Fill in All Fields", Toast.LENGTH_SHORT ).show();
                    finish();
                }
                else {

                    DatabaseHelper db = new DatabaseHelper( Spurs.this );
                    TeamsModel teamsModel = new TeamsModel( name, position, age );
                    db.addSPURS( teamsModel );
                    Toast.makeText( Spurs.this, "Registered Successfully!", Toast.LENGTH_SHORT ).show();
                    finish();
                    Intent intent = new Intent( Spurs.this, Spurs.class );
                    startActivity( intent );
                }
            }
        } );
        button_view.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Spurs.this, SpursPlayerDetails.class );
                startActivity( intent );
            }
        } );
    }
}
