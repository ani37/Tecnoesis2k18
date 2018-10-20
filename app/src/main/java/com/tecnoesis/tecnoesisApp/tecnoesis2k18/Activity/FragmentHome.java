package com.tecnoesis.tecnoesisApp.tecnoesis2k18.Activity;


import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tecnoesis.tecnoesisApp.tecnoesis2k18.Adapters.HomeFragmentPagerAdapter;
import com.tecnoesis.tecnoesisApp.tecnoesis2k18.Adapters.HomePagerAdapter;
import com.tecnoesis.tecnoesisApp.tecnoesis2k18.R;

public class FragmentHome extends Fragment{

    private ViewPager viewPager;
     HomePagerAdapter homePagerAdapter;

      ViewPager fragmentViewPager;
      HomeFragmentPagerAdapter fragmentAdapter;
      TabLayout tabs;
        AppBarLayout appbar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        //collapsing toolbar/appbar
        appbar = view.findViewById(R.id.appbar_layout);



        //setting up the view pager for the home fragments
        fragmentViewPager = view.findViewById(R.id.home_fragment_viewpager);
        fragmentAdapter = new HomeFragmentPagerAdapter(getChildFragmentManager(), getActivity());
        fragmentViewPager.setAdapter(fragmentAdapter);

        //settng up the tablayout
        tabs = view.findViewById(R.id.homeSecondaryTab);
        tabs.setupWithViewPager(fragmentViewPager);
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(getResources().getColor(R.color.tab_highlight), PorterDuff.Mode.SRC_IN);
                appbar.setExpanded(false);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(getResources().getColor(R.color.tab_normal), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                appbar.setExpanded(false);

            }
        });
        tabs.getTabAt(0).setIcon(R.drawable.icon_events_24dp);
        tabs.getTabAt(0).setText("NITS HACKS 2.0");
        tabs.getTabAt(1).setIcon(R.drawable.icon_modules_24dp);
        tabs.getTabAt(1).setText("Modules");
        tabs.getTabAt(2).setIcon(R.drawable.icon_spark_24dp);
        tabs.getTabAt(2).setText("Spark");
        tabs.getTabAt(0).getIcon().setColorFilter(getResources().getColor(R.color.tab_highlight), PorterDuff.Mode.SRC_IN);
        tabs.setSelectedTabIndicatorHeight(0);

        return view;


    }
}
