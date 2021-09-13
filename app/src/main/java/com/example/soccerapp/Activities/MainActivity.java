package com.example.soccerapp.Activities;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.soccerapp.Db.DatabaseHelper;
import com.example.soccerapp.R;

public class MainActivity extends Activity {

    Button loginbtn;
    EditText Email, Password;
    String EmailHolder, PasswordHolder;
    Boolean EditTextEmptyHolder;
    TextView createText;
    SQLiteDatabase sqLiteDatabaseObj;
    DatabaseHelper sqLiteHelper;
    Cursor cursor;
    String TempPassword = "NOT_FOUND";
    public static final String UserEmail = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_login );


        Email = (EditText) findViewById( R.id.Email );
        Password = (EditText) findViewById( R.id.password );
        createText = (TextView) findViewById( R.id.createText );
        loginbtn = (Button) findViewById( R.id.loginBtn );
        DatabaseHelper db = new DatabaseHelper( this );

        loginbtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = Email.getText().toString();
                String pass = Password.getText().toString();

                if (email.equals( "" ) || pass.equals( "" )) {
                    Toast.makeText( MainActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT ).show();
                } else {
                    Boolean checkuserpass = db.checkusernamepassword( email, pass );

                    if (checkuserpass == true) {
                        Toast.makeText( MainActivity.this, "Sign in successfull", Toast.LENGTH_SHORT ).show();
                        Intent intent = new Intent( MainActivity.this, TeamsActivity.class );
                        startActivity( intent );
                    } else {
                        Toast.makeText( MainActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT ).show();
                    }
                }
            }});

        createText.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Register.class);
                startActivity( intent );
            }
        } );
    }
}


