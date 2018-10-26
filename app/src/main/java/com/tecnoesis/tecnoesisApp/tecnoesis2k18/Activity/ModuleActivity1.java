package com.tecnoesis.tecnoesisApp.tecnoesis2k18.Activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tecnoesis.tecnoesisApp.tecnoesis2k18.Adapters.CustomModulesTagsAdapter;
import com.tecnoesis.tecnoesisApp.tecnoesis2k18.R;
import com.tecnoesis.tecnoesisApp.tecnoesis2k18.Utils.EventsUtils;
import com.tecnoesis.tecnoesisApp.tecnoesis2k18.Utils.Models.ModuleEvent;

import java.util.List;

public class ModuleActivity1 extends AppCompatActivity {

    CustomModulesTagsAdapter adapter;
    RecyclerView recyclerView;
    private List<ModuleEvent> list;
    TextView tvHeader;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_module_tags);
        tvHeader = findViewById(R.id.tv_module_header);
        String title = "";

        int result = getIntent().getIntExtra("key", -1);
        if(result == -1){
            onBackPressed();
        }else{

            if(result == FragmentModules.KEY_ROBOTRON){
                list = EventsUtils.getRobotronEvents();
                title = "ROBOTRON";
            }else if(result == FragmentModules.KEY_EMPRESSARIO){
                list = EventsUtils.getEmpressarioEvents();
                title = "EMPRESSARIO";
            }
            else if(result == FragmentModules.KEY_SMARKCITY){
                list = EventsUtils.getSmartCityEvents();
                title = "SMARTCITY";
            }
            else if(result == FragmentModules.KEY_ASME){
                list = EventsUtils.getAsmeEvents();
                title = "ASME";
            }
            else if(result ==FragmentModules.KEY_CYBERWARP){
                list = EventsUtils.getCyberWarpEvents();
                title = "CYBERWARP";
            }
            else if(result == FragmentModules.KEY_SCHOOLGENIUS){
                list = EventsUtils.getSchoolGeniusEvents();
                title = "SCHOOL GENIUS";
            }
            else if(result == FragmentModules.KEY_VWARZ){
                list = EventsUtils.getVwarsEvents();
                title = "VWARZ";
            }
            else if(result == FragmentModules.KEY_MYNDSNARE){
                list = EventsUtils.getMyndsnareEvents();
                title = "MYNDSNARE";
            }
            else{
                //test
                list = EventsUtils.getCommingSoons();
                title = "COMING SOON";
            }

        }


        tvHeader.setText(title);
        recyclerView = findViewById(R.id.recycler_tags);
        adapter = new CustomModulesTagsAdapter(this, list, result);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(adapter);
    }
}
