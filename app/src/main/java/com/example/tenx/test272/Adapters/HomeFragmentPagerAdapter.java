package com.example.tenx.test272.Adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.tenx.test272.Activity.FragmentEvents;
import com.example.tenx.test272.Activity.FragmentModules;
import com.example.tenx.test272.Activity.FragmentSpark;
import com.example.tenx.test272.Activity.FragmentWorkshops;

import com.example.tenx.test272.Utils.EventsUtils;

public class HomeFragmentPagerAdapter extends FragmentPagerAdapter{
    private Context context;

    public HomeFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }


    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = new FragmentEvents();
                break;
            case 1:
                fragment = new FragmentWorkshops();
                break;
            case 2:
                fragment = new FragmentModules();
                break;
            case 3:
                fragment = new FragmentSpark();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
