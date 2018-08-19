package com.example.tenx.test272.Activity;


import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tenx.test272.Adapters.HomeFragmentPagerAdapter;
import com.example.tenx.test272.Adapters.HomePagerAdapter;
import com.example.tenx.test272.Adapters.Listeners.CircularPagerHandler;
import com.example.tenx.test272.R;

import java.util.Timer;
import java.util.TimerTask;

public class FragmentHome extends Fragment{

    private ViewPager viewPager;
     HomePagerAdapter homePagerAdapter;
     Timer timer;
      ViewPager fragmentViewPager;
      HomeFragmentPagerAdapter fragmentAdapter;
      TabLayout tabs;
      AppBarLayout appBarLayout;

    int current_page = 0;
    final long DELAY_MS = 500;
    final long PERIOD_MS = 3500;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        viewPager = view.findViewById(R.id.home_view_pager);
        homePagerAdapter = new HomePagerAdapter(getActivity());
        viewPager.addOnPageChangeListener(new CircularPagerHandler(viewPager, homePagerAdapter));
        viewPager.setAdapter(homePagerAdapter);


        //appbar
        appBarLayout = view.findViewById(R.id.home_appbar_layout);







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
              appBarLayout.setExpanded(false);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(getResources().getColor(R.color.tab_normal), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

                appBarLayout.setExpanded(false);

            }
        });
        tabs.getTabAt(0).setIcon(R.drawable.icon_events_24dp);
        tabs.getTabAt(0).setText("Events");
        tabs.getTabAt(1).setIcon(R.drawable.icon_workshop_24dp);
        tabs.getTabAt(1).setText("Workshops");
        tabs.getTabAt(2).setIcon(R.drawable.icon_modules_24dp);
        tabs.getTabAt(2).setText("Modules");
        tabs.getTabAt(3).setIcon(R.drawable.icon_spark_24dp);
        tabs.getTabAt(3).setText("Spark");
        tabs.getTabAt(0).getIcon().setColorFilter(getResources().getColor(R.color.tab_highlight), PorterDuff.Mode.SRC_IN);
        tabs.setSelectedTabIndicatorHeight(0);




        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                viewPager.post(new Runnable() {
                    @Override
                    public void run() {
                        int currentItem = viewPager.getCurrentItem();
                        viewPager.setCurrentItem(currentItem+1, true);
                    }
                });
            }
        };
        Timer timer = new Timer();
        timer.schedule(timerTask, 500, 2300);
        return view;
    }
}
