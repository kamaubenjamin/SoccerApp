package com.example.soccerapp.TeamsDetails;


import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soccerapp.Adaper.TeamsAdapter;
import com.example.soccerapp.Db.DatabaseHelper;
import com.example.soccerapp.Methods.TeamsModel;
import com.example.soccerapp.R;

import java.util.List;

public class ChelseaPlayerDetails  extends Activity {

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
        List<TeamsModel> studentsModels = databaseHelper.getChelseaPlayerList();

        if (studentsModels.size() > 0){
            TeamsAdapter studentAdapter = new TeamsAdapter(studentsModels,ChelseaPlayerDetails.this);
            recyclerView.setAdapter(studentAdapter);
        }else {
            Toast.makeText(this, "There is no Student in the database", Toast.LENGTH_SHORT).show();
        }

    }
}