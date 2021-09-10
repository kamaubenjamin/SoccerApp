package com.example.soccerapp.Activities;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soccerapp.Adaper.MyListAdapter;
import com.example.soccerapp.Adaper.MyListData;
import com.example.soccerapp.R;

public class TeamsActivity  extends Activity {

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate( savedInstanceState );
        setContentView( R.layout.activity_teams );

        MyListData[] myListData = new MyListData[]{
                new MyListData("Arsenal", R.drawable.arsenal ),
                new MyListData("ManchesterUnited", R.drawable.manu ),
                new MyListData("ManchesterCity", R.drawable.manc),
                new MyListData("Chelsea", R.drawable.chelsea),
                new MyListData("Spurs", R.drawable.spurs1),
                new MyListData("Leicester", R.drawable.leicester),
                new MyListData("Liverpool", R.drawable.liverpool),

        };

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        MyListAdapter adapter = new MyListAdapter(myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
