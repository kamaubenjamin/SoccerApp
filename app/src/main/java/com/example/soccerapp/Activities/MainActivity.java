package com.example.soccerapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.soccerapp.Db.DatabaseHelper;
import com.example.soccerapp.R;

import java.util.ArrayList;

public class MainActivity extends Activity {

    Button loginbtn ;
    EditText Email, Password ;
    String EmailHolder, PasswordHolder;
    Boolean EditTextEmptyHolder;
    TextView createText;
    SQLiteDatabase sqLiteDatabaseObj;
    DatabaseHelper sqLiteHelper;
    Cursor cursor;
    String TempPassword = "NOT_FOUND" ;
    public static final String UserEmail = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_login );


        Email = (EditText) findViewById( R.id.Email );
        Password = (EditText) findViewById( R.id.password );
        createText = (TextView) findViewById( R.id.createText );
        loginbtn = (Button)findViewById( R.id.loginBtn ) ;



        sqLiteHelper = new DatabaseHelper(this);


        createText.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Register.class);
                startActivity( intent );
            }
        } );

        loginbtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String stringName = Email.getText().toString();
                String stringEmail = Password.getText().toString();
                if (stringName.length() <=0 || stringEmail.length() <=0 || stringEmail.length() <=0){
                    Toast.makeText(MainActivity.this, "Enter All Data", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent( MainActivity.this, TeamsActivity.class );
                    startActivity( intent );
                }

            }
        } );

        //Adding click listener to log in button.
      /*  loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Calling EditText is empty or no method.
                CheckEditTextStatus();

                // Calling login method.
                //LoginFunction();


            }
        });

        // Adding click listener to register button.
        button2.setOnClickListener( new View.OnClickListener() {
            @Override

            public void onClick(View v){


                // Opening new user registration activity using intent on button click.
                Intent intent = new Intent(MainActivity.this, Register.class);
                startActivity(intent);

            }
        });

    }

    // Login function starts from here.
  //  public void LoginFunction(){

   //     if(EditTextEmptyHolder) {

            // Opening SQLite database write permission.
         //   sqLiteDatabaseObj = sqLiteHelper.getWritableDatabase();

            // Adding search email query to cursor.
          //  cursor = sqLiteDatabaseObj.query(DatabaseHelper.TABLE_NAME, null, " " + DatabaseHelper.EMAIL + "=?", new String[]{EmailHolder}, null, null, null);

           // while (cursor.moveToNext()) {

             //   if (cursor.isFirst()) {

                //    cursor.moveToFirst();

                    // Storing Password associated with entered email.
                    //TempPassword = cursor.getString(cursor.getColumnIndex(DatabaseHelper.PASS));

                    // Closing cursor.
                  //  cursor.close();
               // }
          //  }

            // Calling method to check final result ..
          //  CheckFinalResult();

       // }
     //   else {

            //If any of login EditText empty then this block will be executed.
      //      Toast.makeText(MainActivity.this,"Please Enter UserName or Password.",Toast.LENGTH_LONG).show();

     //   }

 //   }

    // Checking EditText is empty or not.
    public void CheckEditTextStatus(){

        // Getting value from All EditText and storing into String Variables.
        EmailHolder = Email.getText().toString();
        PasswordHolder = Password.getText().toString();

        // Checking EditText is empty or no using TextUtils.
        if( TextUtils.isEmpty(EmailHolder) || TextUtils.isEmpty(PasswordHolder)){

            EditTextEmptyHolder = false ;

        }
        else {

            EditTextEmptyHolder = true ;
        }
    }

    // Checking entered password from SQLite database email associated password.
    public void CheckFinalResult(){

        if(TempPassword.equalsIgnoreCase(PasswordHolder))
        {

            Toast.makeText(MainActivity.this,"Login Successful",Toast.LENGTH_LONG).show();

            // Going to Dashboard activity after login success message.
            Intent intent = new Intent(MainActivity.this, TeamsActivity.class);

            // Sending Email to Dashboard Activity using intent.
            intent.putExtra(UserEmail, EmailHolder);

            startActivity(intent);


        }
        else {

            Toast.makeText(MainActivity.this,"UserName or Password is Wrong, Please Try Again.",Toast.LENGTH_LONG).show();

        }
        TempPassword = "NOT_FOUND" ;
*/


    }


}