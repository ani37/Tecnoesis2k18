package com.tecnoesis.tecnoesisApp.tecnoesis2k18.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import com.tecnoesis.tecnoesisApp.tecnoesis2k18.Adapters.CustomTeamEpandableAdapter;
import com.tecnoesis.tecnoesisApp.tecnoesis2k18.R;
import com.tecnoesis.tecnoesisApp.tecnoesis2k18.Utils.EventsUtils;

public class ActivityTeam extends AppCompatActivity {

    ExpandableListView listView;
    CustomTeamEpandableAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);

        listView = findViewById(R.id.expListView);
        adapter = new CustomTeamEpandableAdapter(this, EventsUtils.getTeamList());
        listView.setAdapter(adapter);



    }
}
