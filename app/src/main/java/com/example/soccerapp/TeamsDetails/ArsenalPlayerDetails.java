package com.example.soccerapp.TeamsDetails;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soccerapp.Adaper.TeamsAdapter;
import com.example.soccerapp.Db.DatabaseHelper;
import com.example.soccerapp.Methods.TeamsModel;
import com.example.soccerapp.R;

import java.util.List;

public class ArsenalPlayerDetails  extends Activity {
    Button button_add, button_view;
    EditText edittext_name, edittext_position, edittext_age;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_arsenaldetails );
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

          //dISPLAYS ARSENAL PLAYER LIST
        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        List<TeamsModel> studentsModels = databaseHelper.getArsenalPlayerList();

        if (studentsModels.size() > 0){
            TeamsAdapter studentAdapter = new TeamsAdapter(studentsModels,ArsenalPlayerDetails.this);
            recyclerView.setAdapter(studentAdapter);
        }else {
            Toast.makeText(this, "There is no Student in the database", Toast.LENGTH_SHORT).show();
        }

    }
}