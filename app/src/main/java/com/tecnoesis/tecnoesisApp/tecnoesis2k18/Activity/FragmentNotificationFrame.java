package com.tecnoesis.tecnoesisApp.tecnoesis2k18.Activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tecnoesis.tecnoesisApp.tecnoesis2k18.R;

public class FragmentNotificationFrame extends Fragment{

    FragmentManager fmanager;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notification_frame, container, false);
        FragmentManager fmanager = getFragmentManager();
        Log.d("Test", "onCreateView called");
        assert fmanager != null;
        FragmentTransaction trans = fmanager.beginTransaction().replace(R.id.container_notif_frame, new FragmentNotifications(), null).addToBackStack(null);
        trans.isAddToBackStackAllowed();
        trans.commit();
        return view;
    }

}
