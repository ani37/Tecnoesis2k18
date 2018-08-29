package com.example.tenx.test272.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.tenx.test272.Activity.ChildFragmentConferenzaResults;
import com.example.tenx.test272.Activity.ChildFragmentOthersResults;
import com.example.tenx.test272.Activity.ChildFragmentRobotronResults;
import com.example.tenx.test272.Activity.FragmentMenu;
import com.example.tenx.test272.Activity.FragmentHotEvents;
import com.example.tenx.test272.Activity.FragmentHome;
import com.example.tenx.test272.Activity.FragmentNotificationFrame;
import com.example.tenx.test272.Activity.FragmentNotifications;

import java.util.ArrayList;
import java.util.List;

public class FragmentAdapter extends FragmentPagerAdapter {
    private final List<android.support.v4.app.Fragment> fragList = new ArrayList<>();

    ChildFragmentRobotronResults fragRobotron;

    private final FragmentManager mFragManager;
    public FragmentAdapter(FragmentManager fm) {
        super(fm);
        mFragManager = fm;
        fragList.add(new FragmentHome());
        fragList.add(new FragmentHotEvents());
        fragList.add(new FragmentNotificationFrame());
        fragList.add(new FragmentMenu());
    }

    @Override
    public android.support.v4.app.Fragment getItem(int i) {
        return fragList.get(i);
    }



    @Override
    public int getCount() {
        return fragList.size();
    }


}
