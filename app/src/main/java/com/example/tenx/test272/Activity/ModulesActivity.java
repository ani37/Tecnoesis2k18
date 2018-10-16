package com.example.tenx.test272.Activity;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.tenx.test272.Adapters.CustomModulesPagerAdapter;
import com.example.tenx.test272.R;
import com.example.tenx.test272.Utils.EventsUtils;
import com.example.tenx.test272.Utils.Models.ModuleEvent;

import java.util.List;

public class ModulesActivity extends AppCompatActivity {
    ViewPager viewPager;
    TabLayout tabLayout;

    CustomModulesPagerAdapter adapter;
    List<ModuleEvent> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_module_slider);
        tabLayout = findViewById(R.id.tab_modules);

        int result = getIntent().getIntExtra("key", -1);
        int pos = getIntent().getIntExtra("pos", -1);

        if(pos == -1){
            onBackPressed();
        }else{

            if(pos == FragmentModules.KEY_ROBOTRON){
                list = EventsUtils.getRobotronEvents();
            }else if(pos == FragmentModules.KEY_EMPRESSARIO){
                list = EventsUtils.getEmpressarioEvents();
            }
            else if(pos == FragmentModules.KEY_SMARKCITY){
                list = EventsUtils.getSmartCityEvents();
            }
            else if(pos == FragmentModules.KEY_ASME){
                list = EventsUtils.getAsmeEvents();
            }
            else if(pos ==FragmentModules.KEY_CYBERWARP){
                list = EventsUtils.getCyberWarpEvents();
            }
            else if(pos == FragmentModules.KEY_SCHOOLGENIUS){
                list = EventsUtils.getSchoolGeniusEvents();
            }
            else if(pos == FragmentModules.KEY_VWARZ){
                list = EventsUtils.getVwarsEvents();
            }
            else if(pos == FragmentModules.KEY_MYNDSNARE){
                list = EventsUtils.getMyndsnareEvents();
            }
            else{
                //test
                list = EventsUtils.getCommingSoons();
            }

        }



        if(list.size() != 0){
            adapter = new CustomModulesPagerAdapter(this, list);
            viewPager = findViewById(R.id.vp_robotron_pager);
            viewPager.setAdapter(adapter);
            tabLayout.setupWithViewPager(viewPager);
            tabLayout.setSelectedTabIndicatorHeight(0);
            tabLayout.setTabTextColors(Color.parseColor("#e4d0d0"), Color.parseColor("#df4516"));
            viewPager.setCurrentItem(result);

        }

    }


}
