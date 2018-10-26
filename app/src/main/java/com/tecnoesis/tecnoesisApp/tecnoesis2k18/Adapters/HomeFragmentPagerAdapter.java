package com.tecnoesis.tecnoesisApp.tecnoesis2k18.Adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.tecnoesis.tecnoesisApp.tecnoesis2k18.Activity.ChildFragmentEvents;
import com.tecnoesis.tecnoesisApp.tecnoesis2k18.Activity.FragmentModules;
import com.tecnoesis.tecnoesisApp.tecnoesis2k18.Activity.FragmentSpark;
import com.tecnoesis.tecnoesisApp.tecnoesis2k18.Activity.FragmentWorkshops;

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
                fragment = new FragmentModules();
                break;
            case 1:
                fragment = new ChildFragmentEvents();
                break;
            case 2:
                fragment = new FragmentSpark();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
