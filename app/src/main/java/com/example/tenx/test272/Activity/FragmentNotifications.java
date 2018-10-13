package com.example.tenx.test272.Activity;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.tenx.test272.Adapters.NotificationsAdapter;
import com.example.tenx.test272.DatabaseElements.AppRepository;
import com.example.tenx.test272.DatabaseElements.Models.Notification;
import com.example.tenx.test272.DatabaseElements.ViewModels.AppViewModel;
import com.example.tenx.test272.R;

import com.github.clans.fab.FloatingActionMenu;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.messaging.FirebaseMessaging;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FragmentNotifications extends Fragment{


    RecyclerView recyclerView;
    NotificationsAdapter adapter;
    private final static String TAG = "FragmentNotifications!";
    private List<Notification> mList;
    private static final String TOG_SAVE_KEY = "togref";



    AppViewModel viewModel;
    AppRepository appRepository ;

    SharedPreferences preferences;

    FloatingActionMenu mFabMenu;
    com.github.clans.fab.FloatingActionButton mFabConfResuts,mFabRobotronResults,mFabOtherResults;




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notifications_home, container, false);
        recyclerView = view.findViewById(R.id.notification_recycler);

        //fabmenu
        mFabMenu = view.findViewById(R.id.fab_menu);
        mFabConfResuts = view.findViewById(R.id.fab_conferenza_results);
        mFabOtherResults = view.findViewById(R.id.fab_others_results);
        mFabRobotronResults = view.findViewById(R.id.fab_robotron_results);

        mFabRobotronResults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.support.v4.app.FragmentManager manager = getFragmentManager();
                assert manager != null;
                android.support.v4.app.FragmentTransaction ft = manager.beginTransaction();
                ft.setCustomAnimations(R.anim.slide_in, R.anim.slide_out);
                ft.addToBackStack(null).replace(R.id.container_notif_frame, new ChildFragmentRobotronResults());
                ft.commit();

            }
        });
        mFabConfResuts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.support.v4.app.FragmentManager manager = getFragmentManager();
                assert manager != null;
                android.support.v4.app.FragmentTransaction ft = manager.beginTransaction();
                ft.setCustomAnimations(R.anim.slide_in, R.anim.slide_out);
                ft.addToBackStack(null).replace(R.id.container_notif_frame, new ChildFragmentConferenzaResults());
                ft.commit();
            }
        });
        mFabOtherResults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.support.v4.app.FragmentManager manager = getFragmentManager();
                assert manager != null;
                android.support.v4.app.FragmentTransaction ft = manager.beginTransaction();
                ft.setCustomAnimations(R.anim.slide_in, R.anim.slide_out);
                ft.replace(R.id.container_notif_frame, new ChildFragmentOthersResults());
                ft.addToBackStack(null).commit();
            }
        });



        appRepository = new AppRepository(Objects.requireNonNull(getActivity()).getApplication());

        //tog btn
        ToggleButton tog = view.findViewById(R.id.tog_subscribe);
        //shared prefs to save the sate of toggle button
        preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        boolean togref = preferences.getBoolean(TOG_SAVE_KEY, true);
        if(togref){
            tog.setChecked(true);
        }else{
            tog.setChecked(false);
        }

        //setting up the view model
        viewModel = ViewModelProviders.of(Objects.requireNonNull(getActivity())).get(AppViewModel.class);
        viewModel.getAllNotifs().observe(this, new Observer<List<Notification>>() {
            @Override
            public void onChanged(@Nullable List<Notification> notifications) {

                      if(adapter == null){
                          adapter = new NotificationsAdapter(getActivity());
                      }
                       adapter.insertAndRefresh(notifications);
                       adapter.notifyDataSetChanged();
                       LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                       layoutManager.setReverseLayout(true);
                       layoutManager.setStackFromEnd(true);
                       recyclerView.setLayoutManager(layoutManager);
                       recyclerView.setAdapter(adapter);
                        Log.d(TAG, "onChanged called");


            }
        });

        //setting onClick for notifications on off
        tog.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    FirebaseMessaging.getInstance().subscribeToTopic("all").addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(getContext(), "Subscribed to notifications", Toast.LENGTH_SHORT).show();
                            SharedPreferences.Editor editor = preferences.edit();
                            editor.putBoolean(TOG_SAVE_KEY, true);
                            editor.apply();
                        }
                    });

                }else{
                    FirebaseMessaging.getInstance().unsubscribeFromTopic("all").addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(getContext(), "Unsubscribed to notifications", Toast.LENGTH_SHORT).show();
                            SharedPreferences.Editor editor = preferences.edit();
                            editor.putBoolean(TOG_SAVE_KEY, false);
                            editor.apply();
                        }
                    });

                }
            }
        });

        //setting up the menu click button
        ImageView ivMenu = view.findViewById(R.id.iv_notif_menu);
        ivMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopup(view);
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }

    public void showPopup(View v){
        PopupMenu popup = new PopupMenu(getActivity(), v);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.notif_menu, popup.getMenu());
        popup.show();
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.menu_removeAll:
                        viewModel.deleteAllNotifs();
                        Toast.makeText(getContext(), "RemoveAll clicked", Toast.LENGTH_SHORT).show();
                        return true;
                }
                return true;
            }
        });
    }





}

