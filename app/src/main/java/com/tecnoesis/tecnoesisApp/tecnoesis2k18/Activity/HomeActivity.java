package com.tecnoesis.tecnoesisApp.tecnoesis2k18.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.preference.PreferenceManager;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.tecnoesis.tecnoesisApp.tecnoesis2k18.Adapters.FragmentAdapter;
import com.tecnoesis.tecnoesisApp.tecnoesis2k18.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.messaging.FirebaseMessaging;
import java.util.Objects;


public class HomeActivity extends AppCompatActivity{



    TabLayout tabLayout;
    FragmentAdapter fragAdapter;
    ViewPager viewPager;
    SharedPreferences preferences;
    public static  int loginResult = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        setContentView(R.layout.activity_home);



        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean firstSub = preferences.getBoolean("sub", false);


        if(!firstSub){
            //subscribe to topic all on first boot
            FirebaseMessaging.getInstance().subscribeToTopic("all").addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Toast.makeText(HomeActivity.this, "Subscribed to notifications", Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putBoolean("sub", true);
                    editor.apply();
                }
            });
        }


        //setting up the tablayout and viewPager
        fragAdapter = new FragmentAdapter(getSupportFragmentManager());
        tabLayout = findViewById(R.id.home_tablayout);
        viewPager = findViewById(R.id.contaier_view_pager);
        viewPager.setAdapter(fragAdapter);

        tabLayout.setupWithViewPager(viewPager);

        Objects.requireNonNull(tabLayout.getTabAt(0)).setIcon(R.drawable.tablayout_icon_home);
        Objects.requireNonNull(tabLayout.getTabAt(1)).setIcon(R.drawable.tablayout_icon_whatshot);
        Objects.requireNonNull(tabLayout.getTabAt(2)).setIcon(R.drawable.tablayout_icon_notifications);
        Objects.requireNonNull(tabLayout.getTabAt(3)).setIcon(R.drawable.tablayout_icon_menu_24dp);

        tabLayout.getTabAt(0).getIcon().setColorFilter(getResources().getColor(R.color.tab_highlight), PorterDuff.Mode.SRC_IN);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(getResources().getColor(R.color.tab_highlight), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(getResources().getColor(R.color.tab_normal), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        tabLayout.setSelectedTabIndicatorHeight(0);
    }

    @Override
    public void onBackPressed() {
        int cur = viewPager.getCurrentItem();
        if(cur >0){
            viewPager.setCurrentItem(cur-1);
        }


    }

    @Override
    protected void onStart() {
        super.onStart();
        loginResult = getIntent().getIntExtra(LoginActivity.LOGIN_KEY, -1);
        if(loginResult != 1){
            FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
            if(currentUser == null){
                Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        }

    }




}
